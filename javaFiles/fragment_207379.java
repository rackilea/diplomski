@RunWith(MockitoJUnitRunner.class)
public class MessageConsumerTest {

    @Mock
    private ConsumerResponse consumerResponse;

    @Mock
    private NotificationConsumer notificationConsumer;

    @InjectMocks
    private MessageConsumer messageConsumer;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getResponseCodeShouldReturn200() {
        Mockito.when(notificationConsumer.fetchWithReturnConsumerResponse()).thenReturn(consumerResponse);
        Mockito.when(consumerResponse.getResponseCode()).thenReturn("200");
        messageConsumer.fetch();
    }

}