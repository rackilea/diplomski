public void sendMessage(String to, String subject, String content) {
    //Create DKIM Signer
    DKIMSigner dkimSigner = null;
    try {
        dkimSigner = new DKIMSigner(properties.getProperty("mail.smtp.dkim.signingdomain"), properties.getProperty("mail.smtp.dkim.selector"), properties.getProperty("mail.smtp.dkim.privatekey"));
        dkimSigner.setIdentity(properties.getProperty("mail.user") + "@" + properties.getProperty("mail.smtp.dkim.signingdomain"));
        dkimSigner.setHeaderCanonicalization(Canonicalization.SIMPLE);
        dkimSigner.setBodyCanonicalization(Canonicalization.RELAXED);
        dkimSigner.setLengthParam(true);
        dkimSigner.setSigningAlgorithm(SigningAlgorithm.SHA1withRSA);
        dkimSigner.setZParam(true);
    } catch (Exception e) {
    e.printStackTrace();
        }
    if(dkimSigner != null) {
        //Create message
        Message message = new SMTPDKIMMessage(session, dkimSigner);
        try {
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setContent(content, "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }   
    }           
}