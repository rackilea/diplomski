// Define DefaultServlet.
Wrapper defaultServlet = rootContext.createWrapper();
defaultServlet.setName("default");
defaultServlet.setServletClass("org.apache.catalina.servlets.DefaultServlet");
defaultServlet.addInitParameter("debug", "0");
defaultServlet.addInitParameter("listings", "false");
defaultServlet.setLoadOnStartup(1);
rootContext.addChild(defaultServlet);
rootContext.addServletMapping("/", "default");