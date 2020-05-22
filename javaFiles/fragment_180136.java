public class CustomClientDetails implements ClientDetails {

    final static Logger log = LoggerFactory.getLogger(CustomClientDetailsManager.class);

    private static final long serialVersionUID = 6725149038554040628L;

    private Customer customer;

    public CustomClientDetails(final Customer customer) {
        this.customer = customer;       
    }       

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return customer.getAccessTokenValidity();
    }

    @Override
    public Map<String, Object> getAdditionalInformation() { 
        final Set<String> additionalInformation = new HashSet<String>();
        additionalInformation.add(customer.getAdditionalInformation());
        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        final Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(customer.getAuthorities()));
        return authorities;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {  
        final Set<String> authorizedGrantTypes = new HashSet<String>();
        authorizedGrantTypes.add(customer.getAuthorizedGrantTypes());
        return authorizedGrantTypes;
    }

    @Override
    public String getClientId() {
        return customer.getClientId();
    }

    @Override
    public String getClientSecret() {
        return customer.getClientSecret();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return customer.getRefreshTokenValidity();
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        final Set<String> registeredRedirectUris = new HashSet<String>();
        registeredRedirectUris.add(customer.getWebServerRedirectUri());
        return registeredRedirectUris;
    }

    @Override
    public Set<String> getResourceIds() {
        final Set<String> resourcesIds = new HashSet<String>();
        resourcesIds.add(customer.getResourceIds());
        return resourcesIds;
    }

    @Override
    public Set<String> getScope() {
        final Set<String> scopes = new HashSet<String>();
        scopes.add(customer.getScope());            
        return scopes;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return false; //TODO: for some reason this is always false
    }

    @Override
    public boolean isScoped() {         
        return true; //TODO: for some reason this is always true
    }

    @Override
    public boolean isSecretRequired() {         
        return true; //TODO: for some reason this is always true
    }

}




public class CustomClientDetailsManager implements ClientDetailsService {

    final static Logger log = LoggerFactory.getLogger(CustomClientDetailsManager.class);

    private final CustomerService customerService;

    @Inject
    public CustomClientDetailsManager(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        final Customer customer = customerService.getCustomerByClientId(clientId);  

        final CustomClientDetails customClientDetails = new CustomClientDetails(customer);

        return customClientDetails;
    }