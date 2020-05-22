public String sendMail(String message, String subject, String recipientAddress,
        HttpSession session) {

    System.out.println("To:" + recipientAddress);
    System.out.println("Subject:" + subject);
    System.out.println("Message:" + message);

    try {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message);
        mailSender.send(email);
    } catch (MailException e) {
        System.out.println("mail not sent...!" + e);
        return "noEmail";
    }
    return "success";

}