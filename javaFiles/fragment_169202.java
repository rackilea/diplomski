@Before
public void setup() {
    MockitoAnnotations.initMocks(this);
    sample = new Sample();
    sample.setVar1(1234);
    sample.setVar2("5678");
    sample.setService(service);
}