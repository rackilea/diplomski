public abstract class Litter<T extends Animal> {  // <-- type bound
  public Litter(Collection<T> animals) { /* ... */ }
  public void addCub(T cub) { /* ... */ }
}

public class KittyLitter extends Litter<Cat> {
  public KittyLitter(Collection<Cat> cats) {
    super(cats);
  }
}