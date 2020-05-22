@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

   @Bean
   public TokenStore tokenStore() {
      return new JdbcTokenStore(dataSource);
   }

   @Override
   public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
      // ...
      // registering an ApprovalStore automaticaly bootstraps `ApprovalStoreUserApprovalHandler`
      endpoints.approvalStore(approvalStore());
   }
}