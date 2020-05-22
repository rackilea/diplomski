public class MyClass {
    public Map<String, ClassLoader> loader = new LinkedHashMap<String, ClassLoader>();

    public static void main(String[] args) {
        try {
            Field field = MyClass.class.getField("loader");
            MyClass instance = new MyClass();
            Map<String, ClassLoader> loader = (Map<String, ClassLoader>) field.get(instance);
            System.out.println(loader.size()); // prints 0
            Map<String, ClassLoader> newLoader = new LinkedHashMap<String, ClassLoader>();
            newLoader.put("adsas", null);
            field.set(instance, newLoader);
            loader = (Map<String, ClassLoader>) field.get(instance); 
            System.out.println(loader.size()); // prints 1
        } catch (Exception e) {
            // do something
        }
    }
}