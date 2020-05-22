import java.util.*;

class SomeClass {
  public int price;
  public String name;
  public SomeClass(String name, int price) {
    this.name = name;
    this.price = price;
  }
}

class PriceOrNameComparator implements Comparator<SomeClass> {

  boolean compareByPrice;

  public PriceOrNameComparator byPrice() {
    this.compareByPrice = true;
    return this;
  }

  public PriceOrNameComparator byName() {
    this.compareByPrice = false;
    return this;
  }

  public int compare(SomeClass a, SomeClass b) {
    if (compareByPrice) {
      return a.price - b.price;
    } else {
      return a.name.compareTo(b.name);
    }
  }

  public Comparator<SomeClass> reverseComparator() {
    return new Comparator<SomeClass>() {
      public int compare(SomeClass a, SomeClass b) {
        int res = PriceOrNameComparator.this.compare(a, b);
        if (res == 0) {
          return 0;
        } else {
          return (res > 0) ? -1 : 1;
        }
      }
    };
  }
}

class Test {
  public static void main(String[] args) {
    SomeClass s1 = new SomeClass("a", 5);
    SomeClass s2 = new SomeClass("b", 4);
    PriceOrNameComparator c = new PriceOrNameComparator().byPrice();
    Comparator<SomeClass> r = c.reverseComparator();
    System.out.println(c.compare(s1, s2)); // 1
    System.out.println(r.compare(s1, s2)); // -1
    c.byName();
    System.out.println(c.compare(s1, s2)); // -1
    System.out.println(r.compare(s1, s2)); // 1
  }
}