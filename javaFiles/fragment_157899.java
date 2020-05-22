public static synchronized void loadAllJars() {
        String path = System.getProperty("user.dir");
        System.out.println(path + "//jars" + " : Jar Path");
        System.out.println(System.getProperty("java.library.path") + " : Home path");
        File jarFile = new File(path + "//jars");
        for (File file : jarFile.listFiles()) {
            System.out.println("Loding jar : " + file.getName());
            try {
                URLClassLoader loader = (URLClassLoader) ClassLoader.getSystemClassLoader();
                URL url = file.toURI().toURL();
                for (URL it : Arrays.asList(loader.getURLs())) {
                    if (it.equals(url)) {
                        return;
                    }
                }
                Method method = URLClassLoader.class.getDeclaredMethod("addURL", new Class[] { URL.class });
                method.setAccessible(true);
                method.invoke(loader, new Object[] { url });
            } catch (final java.lang.NoSuchMethodException | java.lang.IllegalAccessException
                    | java.net.MalformedURLException | java.lang.reflect.InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }