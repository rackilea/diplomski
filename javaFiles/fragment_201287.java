public class EmbeddedTomcatServer extends ExternalResource {

            ...

            @Override
            protected void before() throws Throwable {
                    EmbeddedTomcat.start();
            };

            @Override
            protected void after() {
                    EmbeddedTomcat.stop();
            };
    }