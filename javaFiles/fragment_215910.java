public class MyConfig extends GuiceServletContextListener {
     final Injector parentInjector;

     public MyConfig(Injector injector) {
         this.parentInjector = injector;
     }

     @Override
     protected Injector getInjector() {
         return parentInjector.getChildInjector(new ServletModule() {
             @Override
             protected void configureServlets() {
                 /* Explicitly bind GuiceContainer so that
                  * the child, not root, injector is injected 
                  * into its constructor. */
                 bind(GuiceContainer.class);
                 bind(MyResource.class);
                 serve("*").with(GuiceContainer.class);
             }
         });
     }
 }