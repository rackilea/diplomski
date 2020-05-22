public TestClass {

    @InjectMocks
    private MainService mainService;

    @Mock
    private Service2 service2;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testMe() {
        mainService.doMain();

        verify(service2).doSomethingAnother();

    }

}