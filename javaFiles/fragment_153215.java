public class FooSingleInstance extends FooAbstract{
    private Bar bar;
    @Override
    public Bar getBar(String key) {
        return bar;
    }
}

public class FooMultiInstances extends FooAbstract{
    private Map<String, Bar> barMap;
    @Override
    public Bar getBar(String key) {
        return barMap.get(key);
    }
}