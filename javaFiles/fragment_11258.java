public class VaadinFlowServlet extends com.vaadin.flow.server.VaadinServlet {

@Override
public void init(ServletConfig servletConfig) throws ServletException {
    var registry = 
    ApplicationRouteRegistry.getInstance(servletConfig.getServletContext());
    registry.setPwaConfigurationClass(LoginView.class); // <-- contains @PWA

    super.init(servletConfig);
}