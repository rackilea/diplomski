public MyClass {
    private final RestTemplate restTemplate;

    @Inject
    public MyClass(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}