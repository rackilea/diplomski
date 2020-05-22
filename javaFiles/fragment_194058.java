@WebMvcTest(controllers = SecuredController.class)
@Import(SecuredControllerTest.Config.class)
class SecuredControllerTest {

   @Configuration
   @EnableWebSecurity
   static class Config extends MyWebSecurityConfigurerAdapter {
      @Autowired
      public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
          auth.inMemoryAuthentication().withUser("user").password("pa$$").roles("USER");
          auth.inMemoryAuthentication().withUser("admin").password("pa$$").roles("ADMIN");
      }
   }

   ...
}