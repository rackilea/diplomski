private MockMvc mockMvc;

@Mock
private Service mockService;

@Before
public void setup() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(new Controller(mockService))
            .setHandlerExceptionResolvers(exceptionResolver()) //crutial for standaloneSetup of MockMVC
            .build();
}