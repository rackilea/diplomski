HtmlEmail email = new HtmlEmail();
    //email.setDebug(debugMode);
    email.setBounceAddress("bouce@domain.biz");
    email.setHostName("mySMTPHost");


    email.setFrom("myAddress@mydomain.com");
    email.addTo(emailAddress);
    email.addBcc("bccAddres");

    email.setSubject("Your Subject");
    email.setAuthentication("recipient@snailmail.org", "password");
    email.setSSL(true);
    email.setSmtpPort(465);
    email.setHtmlMsg(html);

public static void sendMail(org.apache.commons.mail.HtmlEmail email)
{       
    email.send();
}