public class So39604931ApplicationTests {

    @Autowired
    @Qualifier("myChain$child.myService.handler")
    public MessageHandler handler;

    @Test
    public void test() {
        handler.handleMessage(new GenericMessage<>("foo"));
    }

}