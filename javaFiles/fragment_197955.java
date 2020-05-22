public class Set implements Iterable<Integer> {

  private LinkedList<Integer> elements;

  public Set() {
    this.elements = new LinkedList<Integer>();
  }

  @Override
  public Iterator<Integer> iterator() {
    return elements.iterator();
  }
}