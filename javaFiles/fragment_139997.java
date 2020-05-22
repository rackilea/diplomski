@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

   @Bean
   UserApprovalHandler userApprovalHandler() {
      return new DefaultUserApprovalHandler();
   }

   @Override
   public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
      // ...
      endpoints.userApprovalHandler(userApprovalHandler());        
   }
}