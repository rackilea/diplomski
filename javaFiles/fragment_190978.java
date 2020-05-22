@Override
public void onStartup(final ServletContext servletContext) throws ServletException
{
  final ApplicationContext parent = new ClassPathXmlApplicationContext(new String[
     {"/com/mydomain/root.context.xml"});

  XmlWebApplicationContext context = new XmlWebApplicationContext();
  context.setConfigLocation("classpath:/com/mydomain/childContext.xml");
  context.setParent(parent);

  ConfigurableWebApplicationContext webappContext = (ConfigurableWebApplicationContext)
     context;
  webappContext.setServletContext(servletContext);
  webappContext.refresh();


  servletContext.addListener(new ContextLoaderListener(webappContext));

  // ... register dispatcher servlets here ...
}