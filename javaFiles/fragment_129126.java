private ObjectMapper mapper;

@Autowired
DefaultProjectTweetSearchProvider(
        Client client,
        @Qualifier("dateObjectMapper") ObjectMapper mapper) {
    this.client = client;
    this.mapper = mapper;
}