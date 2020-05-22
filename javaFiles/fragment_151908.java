@Autowired
private JwtAccessTokenConverter accessTokenConverter;

...
TokenEnhancer tokenEnhancer = accessTokenConverter; // Added this
TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
enhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer)); // and add the enhancer here