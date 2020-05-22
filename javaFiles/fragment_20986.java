JavaMailSenderImpl mailSender = ... instantiate and configure JavaMailSenderImpl here
final byte[] data = .... this holds my PDF data

mailSender.send(new MimeMessagePreparator() {
   public void prepare(MimeMessage mimeMessage) throws Exception {
      MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
     // set from, to, subject using helper
     helper.addAttachment("my.pdf", new ByteArrayResource(data));
   } 
});