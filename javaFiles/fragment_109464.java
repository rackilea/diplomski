public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    System.out.println("Enter in any amount of positive numbers, Enter -1 when finished");

    int i = 0;
    int nextElm = 0;
    int a, b;

    int[] origArray = new int[100]; /* Two arrays at length 100 */
    int[] evenArray = new int[100];

    while (nextElm != -1) {
        System.out.println("Enter next number: ");
        nextElm = scan.nextInt();
        if (nextElm > 0) {
            origArray[i] = nextElm;
            i++;
        }

    }

    int x = 0;

    System.out.println();

    // Displays original array and sorts even numbers to even array +
    // original count
    System.out.printf("\nTotal count of original array is : %d", i);
    System.out.println();
    for (int orgNumber : origArray) {
        if (orgNumber != 0) {
            System.out.print(orgNumber + " ");
        }
        if (orgNumber % 2 == 0) {
            if (orgNumber != 0) {
                evenArray[x] = orgNumber;
                x++;
            }
        }
    }

    System.out.println();

    // Displays sort even numbers to even array + even count
    System.out.printf("\nTotal count of even array is : %d", x);
    System.out.println();
    for (int evenNumber : evenArray) {
        if (evenNumber != 0) {
            System.out.print(evenNumber + " ");
        }
    }

    // Displays sort odd numbers from original array + odd count
    System.out.printf("\nTotal count of orignal array without even is : %d", i - x);
    System.out.println();
    for (int oddNumber : origArray) {
        if (oddNumber % 2 != 0) {
            System.out.print(oddNumber + " ");
        }
    }

}