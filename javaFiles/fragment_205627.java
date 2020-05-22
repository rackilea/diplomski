// Define JspServlet.
Wrapper jspServlet = rootContext.createWrapper();
jspServlet.setName("jsp");
jspServlet.setServletClass("org.apache.jasper.servlet.JspServlet");
jspServlet.addInitParameter("fork", "false");
jspServlet.addInitParameter("xpoweredBy", "false");
jspServlet.setLoadOnStartup(2);
rootContext.addChild(jspServlet);
rootContext.addServletMapping("*.jsp", "jsp");