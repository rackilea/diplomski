@WebServlet(urlPatterns = "/*", asyncSupported = true)
@VaadinServletConfiguration(productionMode = true, ui = MyUI.class)
public static class Servlet extends VaadinServlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        super.init(servletConfig);


        /*
         * Vaadin SessionListener
         */
        getService().addSessionInitListener(new VaadinSessionListener.VaadinSessionInitListener());
        getService().addSessionDestroyListener(new VaadinSessionListener.VaadinSessionDestroyListener());    
    }
}