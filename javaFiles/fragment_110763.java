class AuthorizeClient {                                 // You haven't specified the class name

    private final RestTemplate restTemplate;
    private String grantedUrl;

    public AuthorizeClient(RestTemplate restTemplate) { // Dependency injection through constructor
        this.restTemplate = restTemplate;
    }

    public List<Permission> getPermissions(..) { .. }
}