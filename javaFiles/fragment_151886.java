class StoppingVerticle extends AbstractVerticle {

    @Override
    public void start() {

        System.out.println("Starting");
        vertx.setTimer(TimeUnit.SECONDS.toMillis(5), (h) -> {
            vertx.undeploy(deploymentID());
        });
    }

    @Override
    public void stop() {
        System.out.println("Stopping");
    }
}