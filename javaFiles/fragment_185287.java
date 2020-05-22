@Autowired
JdbcClientDetailsService jdbcClientDetailsService;

...
BaseClientDetails clientDetails = new BaseClientDetails(companyId, resourceIds, scopes, grantTypes, authorities);
clientDetails.setClientSecret("generatedpassword");
jdbcClientDetailsService.addClientDetails(clientDetails);