public interface IPlugin {
    // some methods that all the plugins will have in common
}

private static IPlugin loadIPluginByClassName(String plugInClassName, ClassLoader classLoader) {
    // NOTE: throws NoClassDefFoundError or ClassNotFoundException if cannot load the class
    // or throws ClassCastException if the loaded class does not implement the interface    
    Class<?> cls = classLoader.loadClass(plugInClassName);
    IPlugin ans = (IPlugin) cls.newInstance()
    return ans;
}