VertxResteasyDeployment deployment = new VertxResteasyDeployment();
deployment.start();
deployment.getProviderFactory().register(new RequestIdFeature(getRequiredBean());
deployment.getRegistry().addPerInstanceResource(Processors.class);
vertx.createHttpServer()
            .requestHandler(new VertxRequestHandler(vertx, deployment))
            .listen(8080);