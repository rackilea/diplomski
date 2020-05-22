public static void copyAndPrintEvenNumbers() {

    System.out.println("All the even numbers are: ");
    int count = 0;

    int[] myEvenNumbers = new int[myNumbers.length];
    int count = 0;
    for (int z = 0; z < myNumbers.length; z++) {
        if (myNumbers[z] % 2 ==0) {
            myEvenNumbers[count] = myNumbers[z];
            System.out.println(myEvenNumbers[count]);
            count++;
        }
    }
    System.out.println("There are " + count + " even numbers found");
}