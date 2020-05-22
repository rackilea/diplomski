@Override
public void onApplicationEvent(ContextRefreshedEvent event) {
    ApplicationContext context = event.getApplicationContext();
    if (context instanceof ConfigurableWebApplicationContext) { // sanity check
        final ConfigurableWebApplicationContext ctx =
                (ConfigurableWebApplicationContext) event.getApplicationContext();
        if ("anotherServlet-servlet".equals(ctx.getNamespace())) {
            // Run your initialization business here
        }
    }
}