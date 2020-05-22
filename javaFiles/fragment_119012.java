Properties props = new Properties();
props.put("mail.smtp.starttls.enable","true");
props.put("mail.smtp.auth", "true");  // If you need to authenticate
// Use the following if you need SSL
props.put("mail.smtp.socketFactory.port", d_port);
props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
props.put("mail.smtp.socketFactory.fallback", "false");