public class Test<T> {

  public T contents;

  public Test(T item) {
    contents = item;
  }

  public static void main(String[] args) {

    Test<String> t = new Test<String>("hello");
    System.out.println(t.contents);

  }

}