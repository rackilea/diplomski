public class YourClass {
    private final String name;
    private final String description;
    //more fields...

    //making a private constructor in case you don't want other classes
    //to create instance of this class carelessly
    //like Integer
    private YourClass(String name, String description) {
        this.name = name;
        this.description = description;
        //probably more logic here
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        //sample implementation
        //it can be heavily improved
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        //sample implementation
        //it MUST be heavily improved
        if (o == this) return true;
        if (!(o instanceof YourClass)) return false;
        YourClass other = (YourClass)o;
        return this.name.equals(other.getName());
    }

    //static flyweight manager
    private static class YourClassFlyweight {
        //cache with weak entries
        //wrapped into a synchronized Map
        static final Map<String, YourClass> cache =
            Collections.synchronizedMap(
                new WeakHashMap<String, YourClass>());

        //if you don't want weak entries
        //then just use a ConcurrentHashMap
        //static final Map<String, YourClass> cache =
        //    new ConcurrentHashMap<String, YourClass>()));

        private YourClassFlyweight() { }
    }

    //using Factory Method along with this flyweight implementation
    public static YourClass create(String name, String description) {
        //check if it's not created
        if (YourClassFlyweight.cache.containsKey(name)) {
            //if it is, then return current instance
            return YourClassFlyweight.cache.get(name);
        }
        //otherwise, create the instance and add it into cache
        synchronized(YourClassFlyweight.cache) {
            YourClass newInstance = new YourClass(name, description);
            YourClassFlyweight.cache.put(name, newInstance);
            return newInstance;
        }
    }
}