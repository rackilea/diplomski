public class SomeServiceImpl implements SomeService {

    @Autowired
    private RabbitOperations rabbitOperations;

    @Override
    public void process(Foo foo) {
        this.rabbitOperations.convertAndSend(
                "someExchange", "someRoutingKey", new Foo(foo.getBar().toUpperCase()));
    }

}