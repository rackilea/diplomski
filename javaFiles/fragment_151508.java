import java.util.Arrays;

public class Foo {
   public void method(String[] myStrArray) {
      System.out.println(Arrays.toString(myStrArray));
   }

   public static void main(String[] args) {
      Foo foo = new Foo();
      foo.method(new String[]{"hello", "goodbye"}); // **array created inline**
   }
}