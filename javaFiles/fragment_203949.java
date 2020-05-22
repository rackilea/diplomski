package com.ibm.xsp.utils;

/**
 * @author Tony McGuckin, IBM
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import lotus.domino.Database;
import lotus.domino.Document;
import lotus.domino.MIMEEntity;
import lotus.domino.MIMEHeader;
import lotus.domino.NotesException;
import lotus.domino.Session;
import lotus.domino.Stream;

import com.ibm.domino.xsp.module.nsf.NotesContext;

public class Email {

    private ArrayList<String> sendTo;
      private ArrayList<String> ccList;
      private ArrayList<String> bccList;
      private String senderEmail;
      private String senderName;
      private String subject;
      private String fieldName;
      private String bannerHTML;
      private String bodyHTML;
      private String footerHTML;

      private boolean debugMode = true;

      private static final Pattern imgRegExp = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");

      public Email(){
            this.subject = "";
            this.sendTo = new ArrayList<String>();
            this.ccList = new ArrayList<String>();
            this.bccList = new ArrayList<String>();
      }

      public String getSendTo(){
        if(this.isDebugMode()){
          System.out.println("getSendTo() : " + this.sendTo.toString());
        }
        return this.sendTo.toString().replace("[", "").replace("]", "");
      }

      public void setSendTo(final String sendTo){
        this.sendTo.add(sendTo);
      }

      public String getCcList(){
        if(this.isDebugMode()){
          System.out.println("getCcList() : " + this.ccList.toString());
        }
        return this.ccList.toString().replace("[", "").replace("]", "");
      }

      public void setCcList(final String ccList){
        this.ccList.add(ccList);
      }

      public String getBccList(){
        if(this.isDebugMode()){
          System.out.println("getBccList() : " + this.bccList.toString());
        }
        return this.bccList.toString().replace("[", "").replace("]", "");
      }

      public void setBccList(final String bccList){
        this.bccList.add(bccList);
      }

      public String getSenderEmail(){
        return this.senderEmail;
      }

      public void setSenderEmail(final String senderEmail){
        this.senderEmail = senderEmail;
      }

      public String getSenderName(){
        return this.senderName;
      }

      public void setSenderName(final String senderName){
        this.senderName = senderName;
      }

      public String getSubject(){
        return this.subject;
      }

      public void setSubject(final String subject){
        this.subject = subject;
      }

      public boolean isDebugMode(){
        return this.debugMode;
      }

      public void setDebugMode(final boolean debugMode){
        this.debugMode = debugMode;
      }

      private Session getCurrentSession(){
        NotesContext nc = NotesContext.getCurrentUnchecked();
          return (null != nc) ? nc.getCurrentSession() : null;
      }

      private Database getCurrentDatabase(){
        NotesContext nc = NotesContext.getCurrentUnchecked();
          return (null != nc) ? nc.getCurrentDatabase() : null;
      }

      public void send() throws NotesException, IOException, Exception {
            Session session = getCurrentSession();
            Database database = getCurrentDatabase();
            if (null != session && null != database &&
                null != this.sendTo && null != this.subject &&
                null != this.senderEmail
            ) {
                try {
                    if (this.isDebugMode()) {
                        System.out.println("Started send()");
                    }
                    session.setConvertMime(false);
                    Document emailDocument = database.createDocument();

                    MIMEEntity emailRoot = emailDocument.createMIMEEntity("Body");
                    if (null != emailRoot) {
                        MIMEHeader emailHeader = emailRoot.createHeader("Reply-To");
                        emailHeader.setHeaderVal(this.getSenderEmail());

                        emailHeader = emailRoot.createHeader("Return-Path");
                        emailHeader.setHeaderVal(this.getSenderEmail());

                        final String fromSender = (null == this.getSenderName()) ?
                            this.getSenderEmail() :
                            "\"" + this.getSenderName() + "\" <" + this.getSenderEmail() + ">";

                        emailHeader = emailRoot.createHeader("From");
                        emailHeader.setHeaderVal(fromSender);

                        emailHeader = emailRoot.createHeader("Sender");
                        emailHeader.setHeaderVal(fromSender);

                        emailHeader = emailRoot.createHeader("To");
                        emailHeader.setHeaderVal(this.getSendTo());

                        if (!this.ccList.isEmpty()) {
                            emailHeader = emailRoot.createHeader("CC");
                            emailHeader.setHeaderVal(this.getCcList());
                        }

                        if (!this.bccList.isEmpty()) {
                            emailHeader = emailRoot.createHeader("BCC");
                            emailHeader.setHeaderVal(this.getBccList());
                        }

                        emailHeader = emailRoot.createHeader("Subject");
                        emailHeader.setHeaderVal(this.getSubject());

                        MIMEEntity emailRootChild = emailRoot.createChildEntity();
                        if (null != emailRootChild) {
                            final String boundary = System.currentTimeMillis() + "-" + "ABC";
                            emailHeader = emailRootChild.createHeader("Content-Type");
                            emailHeader.setHeaderVal("multipart/alternative; boundary=\"" + boundary + "\"");

                            MIMEEntity emailChild = emailRootChild.createChildEntity();
                            if (null != emailChild) {

                                Stream stream = session.createStream();                             

                                emailChild = emailRootChild.createChildEntity();
                                stream = session.createStream();
                                stream.writeText(this.getHTML());
                                emailChild.setContentFromText(stream, "text/html; charset=\"UTF-8\"", MIMEEntity.ENC_NONE);
                                stream.close();
                                stream.recycle();
                                stream = null;
                            }                   
                        }
                    }
                    emailDocument.send();
                    session.setConvertMime(true);
                    if (this.isDebugMode()) {
                        System.out.println("Completed send()");
                    }
                } catch (NotesException e) {
                    if (this.isDebugMode()) {
                        System.out.println("Failed send() with NotesException" + e.getMessage());
                    }
                    throw e;
                }  catch (Exception e) {
                    if (this.isDebugMode()) {
                        System.out.println("Failed send() with Exception" + e.getMessage());
                    }
                    throw e;
                }
            }
        }

      public String getFieldName(){
        return this.fieldName;
      }

      public void setFieldName(final String fieldName){
        this.fieldName = fieldName;
      }

      public String getHTML(){
        StringBuffer html = new StringBuffer();
        html.append(getBannerHTML());
        html.append(getBodyHTML());
        html.append(getFooterHTML());
        return html.toString();
      }

      public String getBannerHTML(){
        return this.bannerHTML;
      }

      public void setBannerHTML(final String bannerHTML){
        this.bannerHTML = bannerHTML;
      }

      public String getFooterHTML(){
        return this.footerHTML;
      }

      public String getBodyHTML() {
        return bodyHTML;
    }

    public void setBodyHTML(String bodyHTML) {
        this.bodyHTML = bodyHTML;
    }

    public void setFooterHTML(final String footerHTML){
        this.footerHTML = footerHTML;
    }      

}