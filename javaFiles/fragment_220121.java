try {
    arraySize = keyboard.nextInt();
 }
 catch(NegativeArraySizeException mistake) {
    System.out.println("Do not enter a negative number for the arrays size.");
    System.out.println();
    isValid = false;
    keyboard.nextLine();
 }
 catch(Exception mistake) {
    System.out.println("Make sure to enter a valid number.");
    System.out.println();
    isValid = false;
    keyboard.nextLine();
   }