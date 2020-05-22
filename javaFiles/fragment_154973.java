@Autowired
    PersonService personService;

    @Autowired
    PeopleController peopleController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
    peopleController = new PeopleController(new personServiceMock());
    mvc = MockMvcBuilders.standaloneSetup(peopleController).build();
   }    

    @Configuration
    static class Config {
        // Other beans
        @Bean
        public PersonService getPersonService() {
            return mock(PersonService.class);
        }
    }
    @Test
    public void testPeople() throws Exception {
        // When
        ResultActions actions = mockMvc.perform(get("/people"));
    }
}