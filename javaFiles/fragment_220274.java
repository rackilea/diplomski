@DataProvider
public Object[][] dp() {
  List<Object[]> result = Lists.newArrayList();
  for (int i : Arrays.asList(10, 20, 50)) {
    for (int j : Arrays.asList(50, 100, 200)) {
      result.add(new Object[] { i, j });
    }
  }
  return result.toArray(new Object[result.size()][]);
}

@Test(dataProvider = "dp")
public void testSomething(int age, int weight) {
  System.out.println("Age:" + age + " weight:" + weight);
}