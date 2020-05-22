public interface ServiceInterface {

}

public class PluginHost {   

    public ServiceLoader<ServiceInterface> loadPlugins() {
        File[] pluginLibraries = getPluginLibraries();
        URL[] pluginLibUrls = new URL[pluginLibraries.length];

        for (int i = 0; i < pluginLibUrls.length; i++) {
            try {
                pluginLibUrls[i] = pluginLibraries[i].toURI().toURL();
            } catch (MalformedURLException e) {
                throw new IllegalStateException("Unable to load plugin: "
                        + pluginLibraries[i], e);
            }
        }

        URLClassLoader pluginsClassLoader = new URLClassLoader(pluginLibUrls,
                ServiceInterface.class.getClassLoader());

        ServiceLoader<ServiceInterface> serviceLoader = ServiceLoader.load(
                ServiceInterface.class, pluginsClassLoader);

        return serviceLoader;
    }

    private File[] getPluginLibraries() {
        // please implement
    }
}