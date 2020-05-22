import java.util.Scanner; 
public class HelloWorld {

 public static void main(String[] args){
    Scanner a = new Scanner(System.in);
    Scanner b = new Scanner(System.in);
    int varTwo = b.nextInt();
    int varOne = a.nextInt();
    int result = plus(varOne, varTwo);

   }
   public static int plus (int aa, int bb) {
      return aa+bb;
   }

}