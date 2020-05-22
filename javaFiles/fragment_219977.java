public class Test {
  public static void main(String[] args){
    String[] stringsBase = {"aaa", "bbb", "ccc"};
    Object[] objects = stringsBase;
    String[] strings = (String[])objects;
    System.out.println(strings[1]);
  }
}