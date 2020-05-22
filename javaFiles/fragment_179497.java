public class Test {

    private Service1 service1;
    private Service2 service2;

    @Inject
    public Test(Service1 service1, Service2 service2) {
        this.service1 = service1;
        this.service2 = service2;
    }
}