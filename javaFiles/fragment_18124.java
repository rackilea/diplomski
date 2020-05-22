ClassLoader ctxLoader = Thread.currentThread().getContextClassLoader();
URL propsURL = ctxLoader.getResource("opto-mapping.properties");
URLConnection propsConn = propsURL.openConnection();
long propsLastModified = propsConn.getLastModified();
// decide if you want to reload...
propsConn.setUseCaches(false);
InputStream propsIn = propsConn.getInputStream();
ResourceBundle propsBundle = new PropertyResourceBundle(propsIn);
propsIn.close();
LocalizationContext propsCtx = new LocalizationContext(propsBundle);
ServletContext servletCtx = this.filterConfig.getServletContext();
Config.set(servletCtx, Config.FMT_LOCALIZATION_CONTEXT, propsCtx);