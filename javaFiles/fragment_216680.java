public Object[][] dp1() {
  return new Object[][] {
      new Object[] { "a", "b" },
      new Object[] { "c", "d" },
  };
}

public Object[][] dp2() {
  return new Object[][] {
      new Object[] { "e", "f" },
      new Object[] { "g", "h" },
  };
}

@DataProvider
public Object[][] dp() {
  List<Object[]> result = Lists.newArrayList();
  result.addAll(Arrays.asList(dp1()));
  result.addAll(Arrays.asList(dp2()));
  return result.toArray(new Object[result.size()][]);
}

@Test(dataProvider = "dp")
public void f(String a, String b) {
  System.out.println("f " + a + " " + b);
}