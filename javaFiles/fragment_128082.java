public class ColorFactory {
    private static class ColorFactoryHolder {
        // same as above, snipped for brevity
    }
    public static ColorFactory getInstance() { return ColorFactoryHolder.instance; }
    // requires ConcurrentMap reference to get putIfAbsent(K,V) method
    ConcurrentMap<String,Color> colormap = new ConcurrentHashMap<String,Color>();
    // private final Object lock = new Object(); - removed
    private ColorFactory() {
        colormap.add("blue",new Color(0,0,255));
        // rest of colors here
    }
    public Color getColor(String spec) {
        Color result = colormap.get(spec);
        if(result == null) {         
            result = parse(spec); // may parse multiple times, but still
                                  // cheaper than synchronization
            colormap.putIfAbsent(spec,result);            
        }
        return result
    }
    private static Color parse(String spec) {
        // parse the color spec here
    }    
}