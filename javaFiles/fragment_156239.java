public class ServerConfig implements ServletContextAware{
    private String serverRootUrl;
    public String getServerRootUrl(){ return serverRootUrl; }
    public void setServletContext(ServletContext servletContext){
        this.serverRootUrl=servletContext.getRealPath("/");
    }
}