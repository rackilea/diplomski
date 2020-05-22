@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {

    @Mock
    private MessageDAO messageDAO = mock(MessageDAO.class);

    private MessageService messageService = new MessageService();

    @Before
    public void setup() {
        messageService.setDao(messageDAO);
    }

    @Test
    public void testAcceptFromOffice() throws Exception {
        //given
        final Message message = new Message();

        //when
        messageService.acceptFromOffice(message);

        //then
        ArgumentCaptor<Message> captor = ArgumentCaptor.forClass(Message.class);

        verify(messageDAO, times(2)).makePersistent(captor.capture());

        final List<Message> params = captor.getAllValues();
        assertThat(params).containsExactly(message, message);

        assertThat(params.get(0).getStatus()).isEqualTo(0);
        assertThat(params.get(1).getStatus()).isEqualTo(1);
    }

}