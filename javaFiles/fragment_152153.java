String webappDirLocation = "src/main/webapp/";
Tomcat tomcat = new Tomcat();
tomcat.setPort(8080);

StandardContext ctx = (StandardContext) tomcat.addWebapp("/embeddedTomcat",
                new File(webappDirLocation).getAbsolutePath());

//declare an alternate location for your "WEB-INF/classes" dir:     
File additionWebInfClasses = new File("target/classes");
VirtualDirContext resources = new VirtualDirContext();
resources.setExtraResourcePaths("/WEB-INF/classes=" + additionWebInfClasses);
ctx.setResources(resources);

tomcat.start();
tomcat.getServer().await();