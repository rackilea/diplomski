public static class ConfigCollector implements Collector<EndPoint, ConfigCollector, ConfigCollector>
{
    List<Config1> config1s = new CopyOnWriteArrayList<>();
    List<Config2> config2s = new CopyOnWriteArrayList<>();
    List<Config3> config3s = new CopyOnWriteArrayList<>();

    public List<Config1> getConfig1s() { return config1s; }
    public List<Config2> getConfig2s() { return config2s; }
    public List<Config3> getConfig3s() { return config3s; }

    @Override
    public BiConsumer<ConfigCollector, EndPoint> accumulator()
    {
        return (cc, e) -> {
            cc.config1s.addAll(ConfigHelper.getConfig1(endPoint));
            cc.config2s.addAll(ConfigHelper.getConfig2(endPoint));
            cc.config3s.addAll(ConfigHelper.getConfig3(endPoint));
        };
    }

    @Override
    public Set<java.util.stream.Collector.Characteristics> characteristics()
    {
        HashSet<java.util.stream.Collector.Characteristics> set = new HashSet<>();
        set.add(Characteristics.IDENTITY_FINISH);
        set.add(Characteristics.UNORDERED);
        set.add(Characteristics.CONCURRENT);
        return set;
    }

    @Override
    public BinaryOperator<ConfigCollector> combiner()
    {
        return (cc1, cc2) -> {
            cc1.config1s.addAll(cc2.config1s);
            cc1.config2s.addAll(cc2.config2s);
            cc1.config3s.addAll(cc2.config3s);
            return cc1;
        };
    }

    @Override
    public Function<ConfigCollector, ConfigCollector> finisher()
    {
        return Function.identity();
    }

    @Override
    public Supplier<ConfigCollector> supplier()
    {
        return ConfigCollector::new;
    }
}