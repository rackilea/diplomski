public class ClassTest {

  public static void main(String[] args) {
    Collection<Class> classes = new ArrayList<>(3);
    classes.add(String.class);
    classes.add(Integer.class);
    classes.add(ClassTest.class);

    for (Class storedClass : classes) {
      System.out.println(storedClass.getSimpleName());
    }
  }

}