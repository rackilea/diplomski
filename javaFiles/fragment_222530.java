@Autowired
@Qualifier("standardMapper")
private ObjectMapper standardObjectMapper;

@Autowired
@Qualifier("specialMapper")
private ObjectMapper specialObjectMapper;