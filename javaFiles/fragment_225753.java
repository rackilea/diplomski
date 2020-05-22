MimeMessage message = sender.createMimeMessage();
MimeMessageHelper helper = new MimeMessageHelper(message);

try {
    helper.setTo(recipients);
    helper.setSubject("Simple mail template");
    helper.setText(someClass.generateMailHtml("Hi There"), true);
} catch (MessagingException e) {
    e.printStackTrace();
}