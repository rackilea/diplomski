@WebServlet(urlPatterns = {"/odata/*"}, initParams = {
        @WebInitParam(name = "javax.ws.rs.Application", value = "org.apache.olingo.odata2.core.rest.app.ODataApplication"),
        @WebInitParam(name = "org.apache.olingo.odata2.service.factory", value = "com.context.JPAServiceFactory")
})
public class MyODataServlet extends ODataServlet {

}