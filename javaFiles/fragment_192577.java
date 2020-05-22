@WebListener
public class Config implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent event) {
    JspFactory.getDefaultFactory().getJspApplicationContext(event.getServletContext()).addELContextListener((ELContextEvent e) -> {
      e.getELContext().getImportHandler().importPackage("java.time");
    });
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {}
}