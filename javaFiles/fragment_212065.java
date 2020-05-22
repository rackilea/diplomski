public class MyTestClass() {
  @Rule
  public TestRule MyEntityManagerInjectRule =
         new MyEntityManagerInjectRule(this); // pass instance to constructor

  //MyEntityManagerInjectRule "inject" the entity manager
  EntityManger em;

  @Test...
}