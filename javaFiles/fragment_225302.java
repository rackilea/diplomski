public class HelloWorld {
  public static void main(String[] args)
  {
    List list = new ArrayList();
    list.add("test1");
    breakStuff(list);
    System.out.println(list.toString());
  }

  public static void breakStuff( List l ) {
    l.add("test2");
    l = new ArrayList();
    l.add("foo");
  }
}