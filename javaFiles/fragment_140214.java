@Override
public void init(FilterConfig filterConfig)    
{
    ServletContex sc = filterConfig.getServletContext();
    appContext = WebApplicationContextUtils.getWebApplicationContext(sc);
    logger.debug("Filter {} initialisiert. App-Context: {} {}", this.getClass().getName(),appContext.hashCode(), appContext);
}