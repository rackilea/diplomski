io.undertow.servlet.api.ServletContainer 
            servletContainer = Servlets.defaultContainer();
DeploymentInfo di = Servlets.deployment().setClassLoader(App.class.getClassLoader())
.addServlets(servlet("servletName", ServletClass.class)
.setLoadOnStartup(1).setAsyncSupported(true)

DeploymentManager manager = servletContainer.addDeployment(di);

manager.deploy();

Undertow.builder()
            .addHttpListener(8080, "localhost")
.setHandler(Handlers.path().addPrefixPath("/", manager.start())).build().start();