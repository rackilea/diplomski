public class ObjectList {
  private final List<Cat> cats;
  private final List<Dog> dogs; 

  public ObjectList() {   
    cats = new ArrayList<Cat>();
    dogs = new ArrayList<Dog>();
  }

  public void addCat(Cat c) {
    cats.add(c);
  }

  public void addDog(Dog d) {
    dogs.add(d);
  }
}