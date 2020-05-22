/**
  * Copyright (c) 2008 Steven M. Cherry
  * All rights reserved.
  */
package utils.scheduled;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.Vector;

import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;

import glob.ActionLogicImplementation;
import glob.IOConn;
import glob.log.Log;
import logic.utils.sql.Settings;
import logic.utils.sqldo.EMail;
import logic.utils.sqldo.EMailAttach;

/**
  * This will connect to our incoming e-mail server and download any e-mails
  * that are found on the server.  The e-mails will be stored for further processing
  * in our internal database.  Attachments will be written out to separate files
  * and then referred to by the database entries.  This is intended to be  run by 
  * the scheduler every minute or so.
  *
  * @author Steven M. Cherry
  */
public class DownloadEMail implements ActionLogicImplementation {

    protected String receiving_host;
    protected String receiving_user;
    protected String receiving_pass;
    protected String receiving_protocol;
    protected boolean receiving_secure;
    protected String receiving_attachments;

    /** This will run our logic */
    public void ExecuteRequest(IOConn ioc) throws Exception {
        Log.Trace("Enter");

        Log.Debug("Executing DownloadEMail");
        ioc.initializeResponseDocument("DownloadEMail");

        // pick up our configuration from the server:
        receiving_host = Settings.getValue(ioc, "server.email.receiving.host");
        receiving_user = Settings.getValue(ioc, "server.email.receiving.username");
        receiving_pass = Settings.getValue(ioc, "server.email.receiving.password");
        receiving_protocol = Settings.getValue(ioc, "server.email.receiving.protocol");
        String tmp_secure = Settings.getValue(ioc, "server.email.receiving.secure");
        receiving_attachments = Settings.getValue(ioc, "server.email.receiving.attachments");

        // sanity check on the parameters:
        if(receiving_host == null || receiving_host.length() == 0){
            ioc.SendReturn();
            ioc.Close();
            Log.Trace("Exit");
            return; // no host defined.
        }
        if(receiving_user == null || receiving_user.length() == 0){
            ioc.SendReturn();
            ioc.Close();
            Log.Trace("Exit");
            return; // no user defined.
        }
        if(receiving_pass == null || receiving_pass.length() == 0){
            ioc.SendReturn();
            ioc.Close();
            Log.Trace("Exit");
            return; // no pass defined.
        }
        if(receiving_protocol == null || receiving_protocol.length() == 0){
            Log.Debug("EMail receiving protocol not defined, defaulting to POP");
            receiving_protocol = "POP";
        }
        if(tmp_secure == null || 
            tmp_secure.length() == 0 ||
            tmp_secure.compareToIgnoreCase("false") == 0 ||
            tmp_secure.compareToIgnoreCase("no") == 0
        ){
            receiving_secure = false;
        } else {
            receiving_secure = true;
        }
        if(receiving_attachments == null || receiving_attachments.length() == 0){
            Log.Debug("EMail receiving attachments not defined, defaulting to ./email/attachments/");
            receiving_attachments = "./email/attachments/";
        }

        // now do the real work.
        doEMailDownload(ioc);

        ioc.SendReturn();
        ioc.Close();
        Log.Trace("Exit");
    }

    protected void doEMailDownload(IOConn ioc) throws Exception {
        // Create empty properties
        Properties props = new Properties();
        // Get the session
        Session session = Session.getInstance(props, null);

        // Get the store
        Store store = session.getStore(receiving_protocol);
        store.connect(receiving_host, receiving_user, receiving_pass);

        // Get folder
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_WRITE);

        try {

            // Get directory listing
            Message messages[] = folder.getMessages();

            for (int i=0; i < messages.length; i++) {
                // get the details of the message:
                EMail email = new EMail();
                email.fromaddr = messages[i].getFrom()[0].toString();
                Address[] to = messages[i].getRecipients(Message.RecipientType.TO);
                email.toaddr = "";
                for(int j = 0; j < to.length; j++){
                    email.toaddr += to[j].toString() + "; ";
                }
                Address[] cc;
                try {
                    cc = messages[i].getRecipients(Message.RecipientType.CC);
                } catch (Exception e){
                    Log.Warn("Exception retrieving CC addrs: %s", e.getLocalizedMessage());
                    cc = null;
                }
                email.cc = "";
                if(cc != null){
                    for(int j = 0; j < cc.length; j++){
                        email.cc += cc[j].toString() + "; ";
                    }
                }
                email.subject = messages[i].getSubject();
                if(messages[i].getReceivedDate() != null){
                    email.received_when = new Timestamp(messages[i].getReceivedDate().getTime());
                } else {
                    email.received_when = new Timestamp( (new java.util.Date()).getTime());
                }


                email.body = "";
                Vector<EMailAttach> vema = new Vector<EMailAttach>();
                Object content = messages[i].getContent();
                if(content instanceof java.lang.String){
                    email.body = (String)content;
                } else if(content instanceof Multipart){
                    Multipart mp = (Multipart)content;

                    for (int j=0; j < mp.getCount(); j++) {
                        Part part = mp.getBodyPart(j);

                        String disposition = part.getDisposition();

                        if (disposition == null) {
                            // Check if plain
                            MimeBodyPart mbp = (MimeBodyPart)part;
                            if (mbp.isMimeType("text/plain")) {
                                Log.Debug("Mime type is plain");
                                email.body += (String)mbp.getContent();
                            } else {
                                Log.Debug("Mime type is not plain");
                                // Special non-attachment cases here of 
                                // image/gif, text/html, ...
                                EMailAttach ema = new EMailAttach();
                                ema.name = decodeName(part.getFileName());
                                File savedir = new File(receiving_attachments);
                                savedir.mkdirs();
                                File savefile = File.createTempFile("emailattach", ".atch", savedir );
                                ema.path = savefile.getAbsolutePath();
                                ema.size = part.getSize();
                                vema.add(ema);
                                ema.size = saveFile(savefile, part);
                            }
                        } else if ((disposition != null) && 
                            (disposition.equals(Part.ATTACHMENT) || disposition.equals(Part.INLINE) ) 
                        ){
                            // Check if plain
                            MimeBodyPart mbp = (MimeBodyPart)part;
                            if (mbp.isMimeType("text/plain")) {
                                Log.Debug("Mime type is plain");
                                email.body += (String)mbp.getContent();
                            } else {
                                Log.Debug("Save file (%s)", part.getFileName() );
                                EMailAttach ema = new EMailAttach();
                                ema.name = decodeName(part.getFileName());
                                File savedir = new File(receiving_attachments);
                                savedir.mkdirs();
                                File savefile = File.createTempFile("emailattach", ".atch", savedir );
                                ema.path = savefile.getAbsolutePath();
                                ema.size = part.getSize();
                                vema.add(ema);
                                ema.size = saveFile( savefile, part);
                            }
                        }
                    }
                }

                // Insert everything into the database:
                logic.utils.sql.EMail.insertEMail(ioc, email);
                for(int j = 0; j < vema.size(); j++){
                    vema.get(j).emailid = email.id;
                    logic.utils.sql.EMail.insertEMailAttach(ioc, vema.get(j) );
                }

                // commit this message and all of it's attachments
                ioc.getDBConnection().commit();

                // Finally delete the message from the server.
                messages[i].setFlag(Flags.Flag.DELETED, true);
            }

            // Close connection 
            folder.close(true); // true tells the mail server to expunge deleted messages.
            store.close();
        } catch (Exception e){
            folder.close(true); // true tells the mail server to expunge deleted messages.
            store.close();
            throw e;
        }

    }

    protected int saveFile(File saveFile, Part part) throws Exception {

        BufferedOutputStream bos = new BufferedOutputStream( new FileOutputStream(saveFile) );

        byte[] buff = new byte[2048];
        InputStream is = part.getInputStream();
        int ret = 0, count = 0;
        while( (ret = is.read(buff)) > 0 ){
            bos.write(buff, 0, ret);
            count += ret;
        }
        bos.close();
        is.close();
        return count;
    }

    protected String decodeName( String name ) throws Exception {
        if(name == null || name.length() == 0){
            return "unknown";
        }
        String ret = java.net.URLDecoder.decode( name, "UTF-8" );

        // also check for a few other things in the string:
        ret = ret.replaceAll("=\\?utf-8\\?q\\?", "");
        ret = ret.replaceAll("\\?=", "");
        ret = ret.replaceAll("=20", " ");

        return ret;
    }

}