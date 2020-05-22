private Config modifyObject(BusinessObject object, BiFunction<ConfigBuilder, BusinessObject, ConfigBuilder> modify) {
    return modify.apply(new ConfigBuilder(), object)
        .config1(p1)
        .config2(p2)
        .config3(p3)
        ...
        .build();
}