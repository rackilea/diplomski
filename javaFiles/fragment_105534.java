public class SearchTestFactory {
   @Factory
   public Object [] createInstances() {
      return new Object[] { new SeartchTest1( SearchType.ONE ), new SearchTest1( SearchType.TWO ) };
   }
}