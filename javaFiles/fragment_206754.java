Properties properties = new Properties();

properties.setProperty("mail.smtp.auth", "true");
properties.setProperty("mail.smtp.starttls.enable", "true");
properties.setProperty("mail.smtp.host", "smtp.gmail.com");
properties.setProperty("mail.smtp.port", "587");
properties.setProperty("mail.smtp.user", gmailUsername);
properties.setProperty("mail.smtp.password", gmailPassword);