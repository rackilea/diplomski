public class SomeSpringBean {
  @Autowired
  private WebApplicationContext appContext;

  public void storeAndRetrieveSomethingInAppScope() {
     appContext.getServletContext().setAttribute(String name, Object object);
     Object fromAppContext = appContext.getServletContext().getAttribute(String name);
  }
}