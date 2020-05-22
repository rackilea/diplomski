@Autowired
@Qualifier("yourRetryPolicy")
private YourRetryPolicy yourRetryPolicy;

//...

RetryTemplate retryTemplate = new RetryTemplate();
retryTemplate.setRetryPolicy( yourRetryPolicy );