@Autowired
   JavaMailSender mailSender;

   public void sendMail(String to, String subject, String content, boolean 
    isMultipart, boolean isHtml){

      MimeMessage mimeMessage = mailSender.createMimeMessage();

      JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
      mailSender.setHost(EMAIL_HOST);
      mailSender.setPort(EMAIL_PORT);
      mailSender.setUsername(EMAIL_USERNAME);
      mailSender.setPassword(EMAIL_PASSWORD);

      Properties properties = mailSender.getJavaMailProperties();
      properties.put("mail.smtp.starttls.enable", Boolean.TRUE);
      properties.put("mail.transport.protocol", "smtp");
      properties.put("mail.smtp.auth", Boolean.TRUE);
      properties.put("mail.smtp.starttls.required", Boolean.TRUE);
      properties.put("mail.smtp.ssl.enable", Boolean.FALSE);
      properties.put("mail.test-connection", Boolean.TRUE);
      properties.put("mail.debug", Boolean.TRUE);

      mailSender.setJavaMailProperties(properties);

      try {
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, isMultipart, "UTF-8");
        messageHelper.setFrom(USER_EMAIL);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(content, isHtml);
        mailSender.send(mimeMessage);
      } catch (Exception ex) {
        log.warn("Email could not be sent to user '{}': {}", to, ex.getMessage());
      }
    }