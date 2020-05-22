@Autowired
private Filter springSecurityFilterChain;
...
mockMvc = MockMvcBuilders.webAppContextSetup(context)
                         .addFilters(springSecurityFilterChain)
                         .build();