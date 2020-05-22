public class MyWebModule extends ServletModule {
    @Override
    protected void configureServlets() {
      // Note: all servlets and filters must be singletons
      bind(FactoryServlet.class).in(Singleton.class);
      // Pass to the HttpServletDispatcher everything but urls ending with static extensions
      serveRegex(".+(?<!\\.(html|css|png|jpg))")
           .with(HttpServletDispatcher.class);
    }
  }