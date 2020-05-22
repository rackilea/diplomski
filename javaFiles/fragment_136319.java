class MailClass extends AsyncTask<String, Void, Void> {
    MimeMessage email;
    String delAddress, pathsList, user, password;
    MimeMultipart multipart = new MimeMultipart();
    Session session;

    protected Void doInBackground( ArrayList<String> imagePaths, String address) throws MessagingException, IOException, EmailException {
        setupEmailConfig();
        delAddress = address;
        Log.i("doInBackground, Count:", String.valueOf(imagePaths.size()));
        createEmail(imagePaths);
        Log.i("doInBackground:", "Email Created Successfully.");
        Transport.send(email);
        Log.i("doInBackground:", "Email Sent.");

        return null;
    }

    private void setupEmailConfig() {
        user = "abc@gmail.com";
        password = "abc";

        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.user", user);
        properties.put("mail.password", password);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.starttls.enable", "true");

        session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });
    }

    private void createEmail(ArrayList<String> imagePaths) throws EmailException, MessagingException, IOException {
        String receiver = "abc@gmail.com";
        String receiverCC = "abc@gmail.com";
        email = new MimeMessage(session);
        email.setFrom(new InternetAddress(user, user));
        email.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(receiver, receiver));
        email.addRecipient(Message.RecipientType.CC, new InternetAddress(receiverCC));
        email.setSubject("Customer Order");
        email.setSentDate(new Date());

        pathsList = "";
        for(int i=0; i<imagePaths.size(); i++) {
            pathsList += "\r\n" + String.valueOf(i+1) + ") " + imagePaths.get(i);
            MimeBodyPart attachPart = new MimeBodyPart();
            attachPart.setDataHandler(new DataHandler(new FileDataSource(imagePaths.get(i))));
            attachPart.setFileName(new File(imagePaths.get(i)).getName());
            multipart.addBodyPart(attachPart);
        }

        MimeBodyPart messageBody = new MimeBodyPart();
        messageBody.setText("Body Text." +
                delAddress + "\r\n List of Images: " + pathsList);

        multipart.addBodyPart(messageBody);
        email.setContent(multipart);
    }

    @Override
    protected Void doInBackground(String... params) {
        return null;
    }
}