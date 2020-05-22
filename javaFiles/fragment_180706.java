@RunWith(Parameterized.class)
class MyTestClass {
  private final SortingAlgorithm algo;

  public MyTestClass(SortingAlgorithm algo) {
    this.algo = algo;
  }

  @Parameters 
  public static List<Object[]> getParameters() {
    List<Object[]> params = new ArrayList<>();
    // Build your list of parameters somehow.
    params.add(new Object[] { new BubbleSort() });
    params.add(new Object[] { new QuickSort() });
    // ...
    return params;
  }

  @Test
  public void test() {
    // Exercise your algorithm somehow.
  }
}