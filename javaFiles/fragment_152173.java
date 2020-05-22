public static class StaticProvider {
  @DataProvider(name = "create")
  public static Object[][] createData() {
    return new Object[][] {
      new Object[] { "Parameter" }
    }
  }
}

public class Courier {
  @Test(dataProvider = "create", dataProviderClass = StaticProvider.class)
  public void Courier_Test(String parameter) {
    // ...
  }
}