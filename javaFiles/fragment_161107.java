@Qualifier
@Retention(Runtime)
public @interface SpringBean {
     @NonBinding String name();
}


public class SpringBeanProducer {

    @Produces @SpringBean
    public Object create(InjectionPoint ip) {
         // get the name() from the annotation on the injection point
         String springBeanName = ip.getAnnotations()....

         //get the ServletContext from the FacesContext
         ServletContext ctx = FacesContext.getCurrentInstance()... 

         return WebApplicationContextUtils
              .getRequiredWebApplication(ctx).getBean(springBeanName);
    }
}