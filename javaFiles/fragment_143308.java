@Component
public class Foo {

    @Autowired
    private JmsTemplate template;

    private int count;

    @Transactional
    public Message test() {
        this.template.setReceiveTimeout(5_000);
        Message received = template.receive("foo");
        System.out.println(received);
        if (this.count++ == 0) {
            throw new RuntimeException();
        }
        return received;
    }

}