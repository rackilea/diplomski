public static class UseRuleChain {
   @Rule
   public TestRule chain= RuleChain
                          .outerRule(new LoggingRule("outer rule")
                          .around(new LoggingRule("middle rule")
                          .around(new LoggingRule("inner rule");

   @Test
   public void example() {
           assertTrue(true);
   }
}