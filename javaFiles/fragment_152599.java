public class EmailServiceTest {

    @Mock
    DirectChannel messageChannel;//you 

    @InjectMocks
    EmailService emailService;

    @Test
    public void shouldSubscribeToSelf(){
       //call method under test
       emailService.init();
       //verify behavior
       Mockito.verify(messageChannel).subscribe(emailService);
    }
}