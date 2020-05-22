@RunWith(MockitoJUnitRunner.class)
public class MailSenderTest {

    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private MailSenderImpl mailSender;

    @Test
    public void testSendMail() {

        String from = "somemail@gmail.com";
        String to = "Danothermail@gmail.com";
        String title = "Test";
        String text = "Hello world!";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(text);

        mailSender.sendMail(to, title, text);

        Mockito.verify(javaMailSender).send(message);
    }

}