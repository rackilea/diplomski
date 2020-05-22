public class Agent {
    public static class Target {

        public static final String GLOBAL_SERVLET_PATTERN = "/globalServlet";
        public static final String GLOBAL_SERVLET_NAME = "globalServlet";

        public boolean intercept(
                @SuperCall Callable<Boolean> zuper
                , @Argument(0) InputSource source
                , @Argument(1) Object dest
                , @Argument(2) boolean fragment
                , @This Object self
        ) {
            try {
                boolean ok = zuper.call();

                if (!fragment) {
                    Method getServletMappings = dest.getClass().getMethod("getServletMappings");
                    Map<String, String> mappings = (Map<String, String>)getServletMappings.invoke(dest);

                    if (!mappings.containsKey(GLOBAL_SERVLET_PATTERN)) {
                        ClassLoader loader = self.getClass().getClassLoader();

                        Class<?> servletDefClass = Class
                        .forName("org.apache.tomcat.util.descriptor.web.ServletDef", true, loader);

                        Object servletDef = servletDefClass.newInstance();

                        servletDefClass.getMethod("setServletClass", String.class)
                        .invoke(servletDef, "io.tair.myagent.GlobalServlet");

                        servletDefClass.getMethod("setServletName", String.class)
                        .invoke(servletDef, GLOBAL_SERVLET_NAME);

                        dest.getClass().getMethod("addServlet", servletDefClass)
                        .invoke(dest, servletDef);

                        dest.getClass().getMethod("addServletMapping", String.class, String.class)
                        .invoke(dest, GLOBAL_SERVLET_PATTERN, GLOBAL_SERVLET_NAME);
                    }

                }

                return ok;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void premain(String agentArgs, Instrumentation inst) {

        new AgentBuilder.Default()
            .type(named("org.apache.tomcat.util.descriptor.web.WebXmlParser"))
            .transform((builder, typeDescription, classLoader) ->
                builder.method (
                    named("parseWebXml")
                    .and(takesArgument(0, InputSource.class))
                )
                .intercept(MethodDelegation.to(new Target()))
            )
            .installOn(inst);

    }
}