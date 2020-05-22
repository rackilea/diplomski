@ApplicationScoped //No need to be request scope, CDI is quite smart
public class RequestContextProvider {

   @Inject
   private HttpServletRequest servletRequest;

   @Produces
   @Dependent //Make dependent if it can be null, if you are sure it cannot be, just declare it as RequestScoped
   public SomethingData createSomethingData(InjectionPoint ip) {
       String requestParam = servletRequest.getParameter("something-data");
       if(requestParam == null) {
           return null;
       }

       return initSomethingData(requestParam);
   }

}