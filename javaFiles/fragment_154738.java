public class InOutExample {
   private final Scanner scanner;
   private final OutputStream out;

   public InOutExample() {
     this(new Scanner(), System.out);
   }
   /** unit test only */
   InOutExample(Scanner scanner, OutputStream out) {
     this.scanner = scanner;
     this.out = out;
   }

   public void foo() {
     if (scanner.next().equals("whatever")) {
       out.println("well"));
     }
   }