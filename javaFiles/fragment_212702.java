@Component
public class SomeBean {

   @Autorwired
   private List<org.springframework.web.servlet.HandlerInterceptor> interceptors;

   @PostConstruct  //not required, but you can use it to print at the app startup
   public void printInterceptors() {
        //TODO use this.interceptors
   }
}