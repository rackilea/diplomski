public class MyListener {

    @Autowired
    private SomeService service;

    @RabbitListener(id = "myListener", queues = "foo")
    public void listen(Foo foo) {
        this.service.process(foo);
    }

}