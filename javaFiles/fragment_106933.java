@Order(1)
public class SpringWebMvcInitializer extends
   AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] { HelloWebSecurityConfiguration.class };
  }
  ...
}

    @Order(2)
    public class SecurityWebApplicationInitializer 
       extends AbstractSecurityWebApplicationInitializer {
    }