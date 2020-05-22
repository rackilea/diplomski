public abstract class SomeTestsForSets {
  Set<Integer> set;

  @Before 
  public abstract void init();

  //test cases...
}

public class HashSetTests extends SomeTestsForSets {

  @Override
  public void init() {
    this.set = new HashSet<>();
  }
}

public class TreeSetTests extends SomeTestsForSets {

  @Override
  public void init() {
    this.set = new TreeSet<>();
  }
}