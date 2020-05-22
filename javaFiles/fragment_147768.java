@RunWith(SpringRunner.class)
@ContextConfiguration(classes = So39708474Application.class)
public class So39708474ApplicationTests {

    @Autowired
    private MessageChannel input;

    @Autowired
    private SubscribableChannel output;

    @Test
    public void contextLoads() {
        AtomicInteger count = new AtomicInteger();
        this.output.subscribe(m -> {
            count.incrementAndGet();
            System.out.println(m);
        });
        this.input.send(new GenericMessage<>("test"));
        assertEquals(2, count.get());
    }

}