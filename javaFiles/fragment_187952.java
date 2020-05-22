properties.put(Constants.FRAMEWORK_SYSTEMPACKAGES_EXTRA, 
        "org.ops4j.pax.url.mvn,org.apache.felix.scr;uses:=\"org.osgi.framework," +
        "org.osgi.service.component\";version=\"1.7\"," +
        "org.apache.felix.scr.component;status=provisional;mandatory:=status;" +
        "uses:=\"org.osgi.service.component\";version=\"1.0\"," +
        "org.osgi.service.component;uses:=\"org.osgi.framework\";version=\"1.2\"");

//Which you pass to the FrameworkFactory ...

ServiceLoader<FrameworkFactory> loader = ServiceLoader.load(FrameworkFactory.class);
Iterator<FrameworkFactory> iterator = loader.iterator();
Framework framework = iterator.next().newFramework(properties);
framework.start();