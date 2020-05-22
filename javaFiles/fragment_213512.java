public static double getInputNumber(Scanner input){
    double num=0;
    while(true) {
              try {
                  num = input.nextDouble();
                  return num;
               } catch (InputMismatchException ex) {
                   System.out.println("Invalid value entered.. Enter again : ");
               } catch (NoSuchElementException ex) {
                   System.out.println("Input exhausted ");
                   return 0;
               } catch (IllegalStateException ex) {
                   System.out.println("Scanner closed ");
                   return 0;
               }
          }
    }
}