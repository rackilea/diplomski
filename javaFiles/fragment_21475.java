// We change the classpath, adding a new jar to the  ClassLoader.(org.apache.commons.lang.builder.ToStringBuilder)
    try {
        // We get the ClassLoader and their method addURL()
        URLClassLoader classLoader = ((URLClassLoader) ClassLoader
                .getSystemClassLoader());
        Method metodoAdd = URLClassLoader.class.getDeclaredMethod("addURL",
                new Class[] { URL.class });
        metodoAdd.setAccessible(true);

        // The URL of the jar we want to add
        URL url = new URL(
                "file:///C:/Users/****/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/*****/WEB-INF/lib/commons-lang-2.6.jar");

        // the method addURL is invoked passing that jar´s url 
        metodoAdd.invoke(classLoader, new Object[] { url });
    } catch (Exception e) {
        e.printStackTrace();
    }