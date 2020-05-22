@Override
protected void configure() {
    bind(RuleExector.class).to(StandardRuleExecutor.class); // Don't forget this one :)

    MapBinder mb = MapBinder.newMapBinder(binder(), String.class, KeyWordExecutor.class);
    mb.addBinding("foo").to(FooKeyWordExecutor.class);
    mb.addBinding("bar").to(BarKeyWordExecutor.class);
    // etc.
}