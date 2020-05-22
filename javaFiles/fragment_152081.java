public class ObjectList {
  private final List cats;
  private final List dogs; 

  public ObjectList() {   
    cats = new ArrayList();
    dogs = new ArrayList();
  }

  public void addCat(Cat c) {
    cats.add(c);
  }

  public void addDog(Dog d) {
    dogs.add(d);
  }
}