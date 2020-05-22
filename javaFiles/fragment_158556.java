RulesModule rules = new AbstractRulesModule() {
  @Override
  public void configure() {
    forPattern("foo")
        .createObject().ofType(Foo.class);
    forPattern("foo/level1/level2/bar")
        .callMethod("setTheBar")
        .withParamCount(1)
        .usingElementBodyAsArgument();
  }
};

DigesterLoader loader = DigesterLoader.newLoader(rules);
Digester digester = loader.newDigester();

Foo foo = (Foo)digester.parse(...);