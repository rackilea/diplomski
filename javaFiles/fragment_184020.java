@RunWith(SpringRunner.class)
@SpringBootTest
public class So49816044ApplicationTests {

    @Autowired
    private Source source;

    @Autowired
    private AmqpAdmin admin;

    @Autowired
    private RabbitTemplate template;

    @Test
    public void test() {
        // bind an autodelete queue to the destination exchange
        Queue queue = this.admin.declareQueue();
        this.admin.declareBinding(new Binding(queue.getName(), DestinationType.QUEUE, "mydest", "#", null));

        this.source.output().send(new GenericMessage<>("foo"));

        this.template.setReceiveTimeout(10_000);
        Message received = template.receive(queue.getName());
        assertThat(received.getBody()).isEqualTo("foo".getBytes());
    }

}