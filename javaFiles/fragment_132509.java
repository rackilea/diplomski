public static class UsesExternalResource {
  private TestRule clientRule = new ExternalResource() {
      @Override
      protected void before() throws Throwable {
        setupClientCode();
      };

      @Override
      protected void after() {
        tearDownClientCode()
    };
  };

  @Rule public TestRule chain = RuleChain
                   .outerRule(clientRule)
                   .around(objectRule);
}