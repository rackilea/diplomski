class TryingSomething {
    private Map<Class<?>, Set<?>> map = new HashMap<>();

    public <T> void addCollection(Set<T> s, Class<T> clazz){
        map.put(clazz, s);
    }

    public void test(){
        Set<Foo> foo = new HashSet<Foo>();
        Set<Bar> bar = new HashSet<Bar>();
        addCollection(foo, Foo.class);
        addCollection(bar, Bar.class);
    }

    @SuppressWarnings("unchecked")
    public <T> Set<T> getCollections(Class<T> clazz){
        return (Set<T>)this.map.get(clazz);
    }


    public static void main(String[] args){
        TryingSomething t = new TryingSomething();
        Set<Foo> foo = new HashSet<Foo>();
        Set<Bar> bar = new HashSet<Bar>();
        t.addCollection(foo, Foo.class);
        t.addCollection(bar, Bar.class);
        Set<Foo> fooList = t.getCollections(Foo.class);
        Set<Bar> barList = t.getCollections(Bar.class);
    }

}

class Foo{
}

class Bar{
}