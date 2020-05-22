public class MyApplication extends Application<MyConfiguration> {

    @Override
    public void run(final MyConfiguration config, Environment env) {
        env.jersey().register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(config).to(MyConfiguration.class);
            }
        });
    }
}