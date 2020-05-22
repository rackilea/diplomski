public List<PluginClass> loadPlugins() throws MalformedURLException, IOException, ClassNotFoundException {
    File plugins[] = new File("./Plugins").listFiles(new FileFilter() {
        @Override
        public boolean accept(File file) {
            return file.getName().endsWith(".jar");
        }
    });
    List<URL> plugInURLs = new ArrayList<>(plugins.length);
    for (File plugin : plugins) {
        plugInURLs.add(plugin.toURI().toURL());
    }
    URLClassLoader loader = new URLClassLoader(plugInURLs.toArray(new URL[0]));
    Enumeration<URL> resources = loader.findResources("/META-INFO/Plugin.properties");
    List<PluginClass> classes = new ArrayList<>(plugInURLs.size());
    while (resources.hasMoreElements()) {
        URL resource = resources.nextElement();
        Properties properties = new Properties();
        try (InputStream is = resource.openStream()) {
            properties.load(is);
            String className = properties.getProperty("enrty-point");
            PluginClass pluginClass = loader.loadClass(className);
            classes.add(pluginClass);
        }
    }
    return classes
}