// Enable parsing of jndi-related parts of web.xml and jetty-env.xml
org.eclipse.jetty.webapp.Configuration.ClassList classlist =
   org.eclipse.jetty.webapp.Configuration.ClassList.setServerDefault(server);

// Enable JNDI
classlist.addAfter("org.eclipse.jetty.webapp.FragmentConfiguration",
   "org.eclipse.jetty.plus.webapp.EnvConfiguration",
   "org.eclipse.jetty.plus.webapp.PlusConfiguration");

// Enable Annotation Scanning
classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
  "org.eclipse.jetty.annotations.AnnotationConfiguration");