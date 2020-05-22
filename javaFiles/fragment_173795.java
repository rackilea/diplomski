Servlet servlet = ...; // Make your servlet, here

ServletContext application = getServletContext();

ServletRegistration.Dynamic reg = application.addServlet("MyNewServlet", servlet);

reg.addMapping("/nyNewServlet");