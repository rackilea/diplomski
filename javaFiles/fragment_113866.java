public class Arguments<T> {
  public List<T> execute() {
    // blah
  }
}

Arguments<Item> o1 = new Arguments<Item>();
List<Item> o2 = o1.execute();