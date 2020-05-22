public class ServletWebServerFactoryWrapper {

    private ServletWebServerFactory servletWebServerFactory;

    public ServletWebServerFactoryWrapper(ServletWebServerFactory servletWebServerFactory){
        this.servletWebServerFactory = servletWebServerFactory;
    }

    public static ServletWebServerFactoryWrapper getWrapper(ServletWebServerFactory servletWebServerFactory){
        return new ServletWebServerFactoryWrapper(servletWebServerFactory);
    }

    public ServletWebServerFactory getFactory(){
        return servletWebServerFactory;
    }
}