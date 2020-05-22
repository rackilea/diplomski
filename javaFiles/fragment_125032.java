...

@Autowired
private Controller controller;

...

@Before
public void setUp() throws Exception {

    ...

    Processor processor = Mockito.mock(Processor.class);
    ReflectionTestUtils.setField(controller, "processor", processor);
}