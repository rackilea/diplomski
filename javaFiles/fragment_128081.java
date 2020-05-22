public class ColorFactory {
    private static class ColorFactoryHolder {
        // creates on instantiation of ColorFactoryHolder
        // synchronization is baked into the JVM, but won't be created until
        // the class is used, see JLS 12.4.1
        static final ColorFactory instance = new ColorMap();
    }
    public static ColorFactory getInstance() { return ColorFactoryHolder.instance; }
    // concurrent hash map - all operations are thread safe
    Map<String,Color> colormap = new ConcurrentHashMap<String,Color>();
    private final Object lock = new Object();
    private ColorFactory() {
        colormap.add("blue",new Color(0,0,255));
        // rest of colors here
    }
    public Color getColor(String spec) {
        if(colormap.containsKey(spec)) return colormap.get(spec);
        // don't synchronize externally - Bloch et al, item 70
        synchronized(lock) { 
            // double check idiom - not broken, as map is thread safe
            if(colormap.containsKey(spec)) return colormap.get(spec);
            Color color = parse(spec); // parse method can be extracted from old code
            colormap.put(spec,color);
            return color;
        }
    }
    private static Color parse(String spec) {
        // parse the color spec here
    }    
}