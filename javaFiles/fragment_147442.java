@RunWith(MockitoJUnitRunner.class)
public class MessengerTest {

    private static final String CLIENT_EMAIL = "some@email.com";
    private static final String MSG_CONTENT = "Dear John! You are fired.";

    @Mock Template template;
    @Mock Client client;
    @Mock MailServer mailServer;
    @Mock TemplateEngine templateEngine;

    @InjectMocks Messenger sut;

    @Test
    public void shouldSendEmail() {
        // given
        when(client.getEmail()).thenReturn(CLIENT_EMAIL);
        when(templateEngine.prepareMessage(template, client)).thenReturn(MSG_CONTENT);

        // when
        sut.sendMessage(client, template);

        // then
        verify(mailServer).send(CLIENT_EMAIL, MSG_CONTENT);
    }
}