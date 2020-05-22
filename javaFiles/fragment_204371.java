@RunWith(MockitoJUnitRunner.class)
public class Test
{
    //Also tried @Mock
    @InjectMocks
    private MyService myService;

    @Mock
    private MyDAO myDAO;

    //@Autowired
    @InjectMocks
    private MyController myController;

    /**
     * This is required for JsonViews.
     * @return
     */
    public static MappingJackson2HttpMessageConverter createJacksonConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);
        return converter;
    }

    @Before
    public void setup() {

        //Build the controller mock handler
        mockMvc = MockMvcBuilders
            .standaloneSetup(myController)
            .setControllerAdvice(new ExceptionHandler())
            .setMessageConverters(createJacksonConverter())
            .build();
    }

    @org.junit.Test
    public void testMyEndpoint() throws Exception
    {
        //Make a request object
        MyRequest request = readJson("request.json", MyRequest.class );

        List<MyObject> objects = readJson("data.json", MyObject.class );

        Mockito.when(
            myDAO.getData( request )
        ).thenReturn(objects);

        Mockito.when(
            myService.callDAO(request)
        )
            .thenReturn(objects)

        //Call the aum endpoint
        ResultActions actions = mockMvc.perform(
            post( "/v1/endpoint" )
                .contentType(MediaType.APPLICATION_JSON)
                .content( new ObjectMapper().writeValueAsString( request ) )
        );

        //Why is this empty?
        System.out.println( actions.andReturn().getResponse().getContentAsString() );
    }
}