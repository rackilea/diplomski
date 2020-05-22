public class main {
  public static void main(String[] argv) {
    Object o1 = test.fetch(type_t.TYPE1);
    Object o2 = test.fetch(type_t.TYPE2);
    Object o3 = test.fetch(type_t.TYPE3);
    Object o4 = test.fetch(type_t.TYPE4);

    if (!(o1 instanceof type1)) {
      System.out.println("Wrong type - o1");
    }
    else {
      System.out.println("o1.getFoo(): " + ((type1)o1).getFoo());
    }

    if (!(o2 instanceof type2)) {
      System.out.println("Wrong type - o2");
    }
    else {
      System.out.println("o2.getFoo(): " + ((type2)o2).getBar());
    }

    if (!(o3 instanceof Integer)) {
      System.out.println("Wrong type - o3");
    }
    else {
      System.out.println("o3.intValue(): " + ((Integer)o3).intValue());
    }

    if (!(o4 instanceof String)) {
      System.out.println("Wrong type - o4");
    }
    else {
      System.out.println("o4: " + (String)o4);
    }
  }
}