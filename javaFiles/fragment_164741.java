public class MyApplication {

private static final Logger LOGGER = LoggerFactory.getLogger(MyApplication.class);

public static void main(String[] args) {

    MyAuthenticationProvider authProvider;

    try (ConfigurableApplicationContext springApplicationContext = new AnnotationConfigApplicationContext(
            MySpringConfiguration.class)) {
        springApplicationContext.registerShutdownHook();
        authProvider = springApplicationContext.getBean(MyAuthenticationProvider.class);
    }

    Authentication request = new UsernamePasswordAuthenticationToken("foo", "foo");
    Authentication result = authProvider.authenticate(request);

    if (result.isAuthenticated()) {
        LOGGER.debug("User is authenticated");
    } else {
        LOGGER.debug("Cannot authenticate user.");
    }

}