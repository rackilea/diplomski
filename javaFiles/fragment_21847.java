public class Example {
   public Example() {
      Scanner scanner = new Scanner(System.console().reader()); 
      // note change on above line
      int row = scanner.nextInt();
      scanner.close();
   }
}