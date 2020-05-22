public class Test {
      public static void main(String args[]) { 
      int i = 78;     // 4 bytes 
      // char ch = i;   // error, 4 bytes to 2 bytes
      char ch = (char) i; // int is type converted to char
      System.out.println(ch); // prints N (78 ASCII value for N)

      System.out.println("Max int:"+Integer.SIZE+"bit");
      System.out.println("Max char:"+Character.SIZE+"bit");

       }
     }