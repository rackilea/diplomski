package com.naveed.workingfiles;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
 import org.apache.commons.mail.MultiPartEmail;

public class Mail {
String senderID;
String senderPassword;
String hostName;
int portNumber;
String attachmentPath;
String subject;
String body;
String cc;
String bcc;


// #=============================================================================================#
public String getBcc() {
    return bcc;
}

// #=============================================================================================#
public void setBcc(String bcc) {
    this.bcc = bcc;
}

// #=============================================================================================#
public String getCc() {
    return cc;
}

// #=============================================================================================#
public void setCc(String cc) {
    this.cc = cc;
}

// #=============================================================================================#
public String getBody() {
    return body;
}

// #=============================================================================================#
public void setBody(String body) {
    this.body = body;
}

// #=============================================================================================#
public String getSubject() {
    return subject;
}

// #=============================================================================================#
public void setSubject(String subject) {
    this.subject = subject;
}

// #=============================================================================================#

public String getSenderID() {
    return senderID;
}

// #=============================================================================================#
public void setSenderID(String senderID) {
    this.senderID = senderID;
}

public String getSenderPassword() {
    return senderPassword;
}

// #=============================================================================================#
public void setSenderPassword(String senderPassword) {
    this.senderPassword = senderPassword;
}

// #=============================================================================================#
public String getHostName() {
    return hostName;
}

// #=============================================================================================#
public void setHostName(String hostName) {
    this.hostName = hostName;
}

// #=============================================================================================#
public int getPortNumber() {
    return portNumber;
}

// #=============================================================================================#
public void setPortNumber(int portNumber) {
    this.portNumber = portNumber;
}

// #=============================================================================================#
public String getAttachmentPath() {
    return attachmentPath;
}

// #=============================================================================================#
public void setAttachmentPath(String attachmentPath) {
    this.attachmentPath = attachmentPath;
}

// #=============================================================================================#
public void sendMail(String receiverId) {

    try {
        // this below commented line for the HTML body text
        // MultiPartEmail htmlEmail = new HtmlEmail();
        // OR
        // HtmlEmail email = new HtmlEmail();

        MultiPartEmail email = new MultiPartEmail();
        // setting the port number
        email.setSmtpPort(getPortNumber());
        // authenticating the user
        email.setAuthenticator(new DefaultAuthenticator(getSenderID(),
                getSenderPassword()));
        // email.setDebug(true);
        email.setSSL(true);
        // setting the host name
        email.setHostName(getHostName());
        // setting the rciever id

        email.addTo(receiverId);

        // check for user enterd cc or not
        if (getCc() != null) {
            // add the cc
            email.addCc(getCc());
        }
        // check for user enterd bcc or not
        if (getBcc() != null) {
            // add the bcc
            email.addBcc(getBcc());
        }
        // setting the sender id
        email.setFrom(getSenderID());
        // setting the subject of mail
        email.setSubject(getSubject());
        // setting message body
        email.setMsg(getBody());
        // email.setHtmlMsg("<h1>"+getBody()+"</h1>");

        // checking for attachment attachment
        if (getAttachmentPath() != null) {
            // add the attachment
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(getAttachmentPath());
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            email.attach(attachment);
        }

        // send the email
        email.send();
        // System.out.println("Mail sent!");
    } catch (Exception e) {
        // System.out.println("Exception :: " + e);
        e.printStackTrace();

    }
}// sendmail()
}// mail