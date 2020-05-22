@Test(dataProvider = "HypotheticalData")
  public void test(Integer n) {
    // ...
  }

  @DataProvider(name = "HypotheticalData")
  public Object[][] createHypotheticalData() {
    return new Object[][] {
      new Object[] { new Integer(10) },
      new Object[] { new Integer(22) }
    };
  }