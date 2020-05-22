public class Class1 {
    public static String[] method1() {
      String[] array = new String[5];
      array[0] = "test";
      return array;
    }

    public void method2(String[] array) {
      System.out.println(array[0]);
    }
public static void main(String[] args){
Class1 obj = new Class1();
obj.method2(method1());
}
       }