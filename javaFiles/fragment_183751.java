public class Test
{
   private static final Scanner SCANNER;

   static {
      SCANNER = new Scanner(System.in);
   }

   public static final void main(final String... args) {
      final String[] numbers = SCANNER.nextLine().trim().split(" ");
      final int consideredElements = Integer.parseInt(numbers[0]);
      float sum = 0;
      int value = 0;

      for (int i = 1; i < numbers.length; i++) {
         sum = 0;

         for (int k = 0; k < consideredElements; k++) {
            value = Integer.parseInt(numbers[i + k]);

            if (value == 0) {
               return;
            }

            sum += value;
         }

         System.out.println(new BigDecimal(sum / consideredElements).setScale(2, RoundingMode.HALF_EVEN));
      }
   }
}