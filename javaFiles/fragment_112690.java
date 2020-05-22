// Elsewhere...
@Autowired
private TestRestTemplate template;

// In your tests...
ErrorJson result = template.getForObject("/error", ErrorJson.class);

// Inspect the result!