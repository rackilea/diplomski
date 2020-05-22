Properties p = new Properties();
p.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
// set any other properties you want
Context context = new InitialContext(p);

Object o = context.lookup("WidgetBeanRemote");