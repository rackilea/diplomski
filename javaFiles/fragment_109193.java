public class MyClass {
    public static void main(String args[]) {
      String input = "aaaaaggff";
      char c = input.charAt(0);
      int count = 1;

      System.out.print(c);
      for (int i = 1; i < input.length(); i++) {
          if (input.charAt(i) == c) {
            System.out.print(input.charAt(i));
            count++;    
          } else {
            System.out.print(count);
            System.out.print(input.charAt(i));  

            count = 1;
            c = input.charAt(i);
          }
      }
      // Print the count of the final character
      System.out.println(count);
    }
}