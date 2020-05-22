@Mock
Provider<ConnectionClass> provider;

ServiceClass1 serviceClass1;

@Before
public void setup() {
    MockitoAnnotations.initMocks(this);
    serviceClass1 = new ServiceClass1(provider);
}