try {
   if (input == 2) {
       System.out.println("Maybe next time!");
       System.exit(0);
   } else if (input == 1) {
       System.out.println("Okay! good luck!\n");
   }else{
       throw new InputMismatchException();
   }
} catch (InputMismatchException e) {
   System.out.println("Invalid input. Try again\n");
}