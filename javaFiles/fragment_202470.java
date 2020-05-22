@Autowired
private JavaMailSender 
private void setMailDetailsForSend( final String payload, final String email ) throws MessagingException
{

    final MimeMessage mail = mailSender.createMimeMessage();
    final MimeMessageHelper helper = new MimeMessageHelper( mail, true );
    helper.setTo( email );
    helper.setSubject( "Notification" );
    helper.setText( "text/html", payload );
    mailSender.send( mail );

}