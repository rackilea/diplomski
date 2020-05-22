@Autowired
   private FilterChainProxy filterChainProxy;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = webAppContextSetup(wac).dispatchOptions(true).addFilters(filterChainProxy).build();
    }