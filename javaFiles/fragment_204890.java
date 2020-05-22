public class MyClass implements Comparable<MyClass> {

@Ovveride
public int compare(MyClass other) {
    if(this.a.compareTo(other.getA()) != 0)
      return this.a.compareTo(other.getA());
    if(this.c.compareTo(other.getC()) != 0)
      return this.c.compareTo(other.getC());
    return return this.b.compareTo(other.getB());
}
}