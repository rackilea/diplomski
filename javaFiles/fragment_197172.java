public class Agent {
    public static class Target {

        public static final String GLOBAL_SERVLET_PATTERN = "/globalServlet";
        public static final String GLOBAL_SERVLET_NAME = "globalServlet";

        public void intercept(
                @SuperCall Callable<Void> zuper
                , @This Object self
        ) {
            try {
                Method getServletMappings = self.getClass().getMethod("getServletMappings");
                Map<String, String> mappings = (Map<String, String>)getServletMappings.invoke(self);

                if (!mappings.containsKey(GLOBAL_SERVLET_PATTERN)) {
                    ClassLoader loader = self.getClass().getClassLoader();

                    Class<?> servletDefClass = Class
                            .forName("org.apache.catalina.deploy.ServletDef", true, loader);

                    Object servletDef = servletDefClass.newInstance();

                    servletDefClass.getMethod("setServletClass", String.class)
                            .invoke(servletDef, "io.tair.myagent.GlobalServlet");

                    servletDefClass.getMethod("setServletName", String.class)
                            .invoke(servletDef, GLOBAL_SERVLET_NAME);

                    self.getClass().getMethod("addServlet", servletDefClass)
                            .invoke(self, servletDef);

                    self.getClass().getMethod("addServletMapping", String.class, String.class)
                            .invoke(self, GLOBAL_SERVLET_PATTERN, GLOBAL_SERVLET_NAME);
                }

                zuper.call();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void premain(String agentArgs, Instrumentation inst) {

        new AgentBuilder.Default()
            .type(named("org.apache.catalina.deploy.WebXml"))
            .transform((builder, typeDescription, classLoader) ->
                builder.method (
                    named("configureContext")
                )
                .intercept(MethodDelegation.to(new Target()))
            )
            .installOn(inst);

    }
}