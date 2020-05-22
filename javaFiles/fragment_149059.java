public class FreightAuthenticatedDataProvider {

    @DataProvider(name = "correctUsercorrectFreight")
    public static Object[][] correctUsercorrectFreight() {
        return new Object[][] {
              // when correctUser() and correctFreights() return Lists, 
              // than it needs to be converted, see comments
              {UserDataProvider.correctUsers(), FreightDataProvider.correctFreights()}
         }; 
     }
}