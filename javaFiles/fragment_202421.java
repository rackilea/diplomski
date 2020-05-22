@Service @Profile("test")
public class MockMailSender implements MailSender {
    //...
}
@Service @Profile("production")
public class ExchangeMailSender implements MailSender {
    //...
}