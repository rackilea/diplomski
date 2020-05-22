@RunWith(Suite.class)
@SuiteClasses({Class1Test.class})
public class TestSuite {
}

@RunWith(FilterRunner.class)
public class Class1Test {
  @Test
  public void test1() {
    System.out.println("test1");
  }

  @Test
  public void test2() {
    System.out.println("test2");
  }
}