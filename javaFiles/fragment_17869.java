package com.mycompany.employee.utils;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Mlungisi
 *
 */
public class GMail {

    public static void sendMail(String senderEmail, String recipientEmail, String subject, String message) throws MessagingException, UnsupportedEncodingException {

        // SSL // I USED THIS METHOD            
        Properties propsSSL = new Properties();

        // EVEN IF YOU SKIP THESE TWO PROP IT WOULD WORK
        propsSSL.put("mail.transport.protocol", "smtps");
        propsSSL.put("mail.smtps.host", "smtp.gmail.com");

        // THIS IS THE MOST IMPORTANT PROP --> "mail.smtps.auth"
        propsSSL.put("mail.smtps.auth", "true");

        Session sessionSSL = Session.getInstance(propsSSL);
        sessionSSL.setDebug(true);

        Message messageSSL = new MimeMessage(sessionSSL);
        messageSSL.setFrom(new InternetAddress("yourgmail@gmail.com", "Mlungisi Sincuba"));
        messageSSL.setRecipients(Message.RecipientType.TO, InternetAddress.parse("yourgmail@gmail.com")); // real recipient
        messageSSL.setSubject("Test mail using SSL");
        messageSSL.setText("This is test email sent to Your account using SSL.");

        Transport transportSSL = sessionSSL.getTransport();
        // EVEN IF YOU SKIP PORT NUMBER , IT WOULD WORK
        transportSSL.connect("smtp.gmail.com", 465, "yourgmail@gmail.com", "yourpassword"); // account used
        transportSSL.sendMessage(messageSSL, messageSSL.getAllRecipients());
        transportSSL.close();

        System.out.println("SSL done.");
    }

    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
        System.out.println("Hello World!");
        sendMail(null, null, null, null);
    }
}