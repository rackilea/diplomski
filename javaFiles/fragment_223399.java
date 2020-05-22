public class RegexSplitPageBrk {


   public static void main(String[] args) {
      String text = "Hello world\nGoodbye cruel world!\nYeah this works!";
      String regex = "(?<=\\n)";  // with look-behind!

      String[] tokens = text.split(regex);

      for (String token : tokens) {
         System.out.print(token);
      }
   }
}