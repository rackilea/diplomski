String webappDirLocation = "src/main/webapp/";
Tomcat tomcat = new Tomcat();
tomcat.setPort(8080);

StandardContext ctx = (StandardContext) tomcat.addWebapp("/embeddedTomcat",
                new File(webappDirLocation).getAbsolutePath());

//declare an alternate location for your "WEB-INF/classes" dir:     
File additionWebInfClasses = new File("target/classes");
WebResourceRoot resources = new StandardRoot(ctx);
resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
ctx.setResources(resources);

tomcat.start();
tomcat.getServer().await();