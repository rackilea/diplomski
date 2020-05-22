@Autowired
public EmailService emailService;

public void sendEmail(){
   final Email email = DefaultEmail.builder()
        .from(new InternetAddress("mymail@mail.co.uk"))
        .replyTo(new InternetAddress("someone@localhost"))
        .to(Lists.newArrayList(new InternetAddress("someone@localhost")))
        .subject("Lorem ipsum")
        .body("Lorem ipsum dolor sit amet [...]")
        .encoding(Charset.forName("UTF-8")).build();

   emailService.send(email);
}