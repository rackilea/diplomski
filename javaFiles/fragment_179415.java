private void printFibonacci(int lengthOfSeries) {

    int lastNumb = 1;
    int secondLastNumb = 1;
    int count = 2;

    if (lengthOfSeries == 0) {
        System.out.println("Please enter number to print series.");

    } else {

        System.out.print("1, 1");

        while (count < lengthOfSeries) {
            int next = lastNumb + secondLastNumb;
            System.out.print(", " + next);
            secondLastNumb = lastNumb;
            lastNumb = next;
            //Updated
            count = count+1;
        }
        System.out.println();
    }

}