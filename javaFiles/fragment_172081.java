public class PluginLoader extends URLClassLoader {

    public PluginLoader(String jar) throws MalformedURLException {
        super(new URL[] { new File(jar).toURI().toURL() });
    }

}