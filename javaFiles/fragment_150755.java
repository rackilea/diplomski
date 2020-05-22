@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class SqsAdapterTest {

    @Autowired
    AmazonSQSAsync amazonSQS;

    @SpyBean
    SeamEventProcessor seamEventProcessor;

    @Autowired
    SqsAdapter adapter;

    @Test
    public void testOnEvent() {
        doNothing().when(seamEventProcessor).process(any());
        String event = "royale with cheese";
        adapter.onEvent(event);
        verify(seamEventProcessor, times(1)).process(event);
    }
}