public class Starter extends Application<Configuration> {

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.jersey().register(HelloWorldResource.class);
    }

    public static void main(String[] args) throws Exception {
        new Starter().run("server", "/Users/artur/dev/repo/dw-test/src/main/resources/configuration.yaml");
    }

}