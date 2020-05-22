@Autowired 
JavaMailSender mailSender


@PostConstruct
public void init(){
    // connect to database
    // obtain properties
    JavaMailSenderImpl ms = (JavaMailSenderImpl) mailSender;
    ms.set...
    ms.set...
    ms.set...
}