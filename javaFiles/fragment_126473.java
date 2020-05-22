private MockMvc mockMvc;

        @Autowired
        private FilterChainProxy springSecurityFilterChain;

        @Autowired
        private WebApplicationContext wac;

        protected MockHttpSession session;

        protected MockHttpServletRequest request;

        @Before
        public void setup() {
            this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).addFilters(this.springSecurityFilterChain).build();
        }

        @Test
        void test(){
        // I log in and then returns session 
        HttpSession session = mockMvc.perform(post("/j_spring_security_check").param("NAME", user).param("PASSWORD", pass))
                    .andDo(print()).andExpect(status().isMovedTemporarily()).andReturn().getRequest().getSession();
        }