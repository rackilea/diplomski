public class Test {
   public static void main(String[] args) {
      new Test().run();
   }

   private void run() {
      String str1 = "Test";
      String str2 = "Test";
      System.out.println(str1 == str2);

      String str3 = new String("Test");
      String str4 = new String("Test");
      System.out.println(str3 == str4);

      String str5 = str3.intern();
      String str6 = str3.intern();
      System.out.println(str5 == str6);
   }
}