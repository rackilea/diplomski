public class Item implements Comparable<Item> {
  private int number;
  private int arrived;

  // the rest of your code

  public int compareTo(Item other) {
    int numberCompare = Integer.compare(other.number, this.number);
    if (numberCompare == 0) {
      return Integer.compare(other.arrived, this.arrived);
    } else {
      return numberCompare;
    }
  }
}