//Java Version
    int port = 587;
    String host = "smtp.gmail.com";
    String user = "username@gmail.com";
    String pwd = "email password";

    try {
        Properties props = new Properties();
        // required for gmail 
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.auth", "true");
        // or use getDefaultInstance instance if desired...
        Session session = Session.getInstance(props, null);
        Transport transport = session.getTransport("smtp");
        transport.connect(host, port, user, pwd);
        transport.close();
        System.out.println("success");
     } 
     catch(AuthenticationFailedException e) {
           System.out.println("AuthenticationFailedException - for authentication failures");
           e.printStackTrace();
     }
     catch(MessagingException e) {
           System.out.println("for other failures");
           e.printStackTrace();
     }



<cfscript>
    //CF Version
    port = 587;
    host = "smtp.gmail.com";
    user = "username@gmail.com";
    pwd = "email password";

    try {
        props = createObject("java", "java.util.Properties").init();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        // or use getDefaultInstance instance if desired...
        mailSession = createObject("java", "javax.mail.Session").getInstance(props, javacast("null", ""));
        transport = mailSession.getTransport("smtp");
        transport.connect(host, port, user, pwd);
        transport.close();
        WriteOutput("success");
     } 
     //for authentication failures
     catch(javax.mail.AuthenticationFailedException e) {
           WriteOutput("Error: "& e.type &" ** "& e.message);
     }
     // for other failures
     catch(javax.mail.MessagingException e) {
           WriteOutput("Error: "& e.type &" ** "& e.message);
     }
</cfscript>