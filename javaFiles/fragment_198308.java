public static void copyAndPrintEvenNumbers() {

    System.out.println("All the even numbers are: ");
    int count = 0;

    for (int i =0; i < myNumbers.length; i++) {
        if (myNumbers[i] % 2 == 0) {
            count++;
        }
    }

    int[] myEvenNumbers = new int[count];
    int myEvenIndex = 0;
    for (int z = 0; z < myNumbers.length; z++) {
        if (myNumbers[z] % 2 ==0) {
            myEvenNumbers[myEvenIndex] = myNumbers[z];
            System.out.println(myEvenNumbers[myEvenIndex]);
            myEvenIndex++;
        }
    }

}