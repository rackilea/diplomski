public abstract class Arguments<T> {
  public List<T> execute() {
    // some stuff
    return new ArrayList<T>();
  }
}

public class ItemArguments extends Arguments<Item> {

}