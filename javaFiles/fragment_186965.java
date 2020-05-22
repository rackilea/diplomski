private static MyViewRegistry registry = null;
public MyViewRegistry getRegistry() {
    if (registry == null) {
        registry = new MyViewRegistry();
        registry.read();
    }
    return registry;
}