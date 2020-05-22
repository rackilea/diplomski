public static void main(String[] args) {

    int[] numbers  = new int[50] ;
    int index = 0;
    int temp;
    Scanner keyboard = new Scanner(System.in);
    // get the user input
    System.out.print("Enter Number: ");
    System.out.println(" ");
    do {
        int input = keyboard.nextInt();
        if (input != -999)
            numbers[index++] = input;
        else
            break;
    } while (index != 0);
    keyboard.close();
    System.out.println("\nNumbers\t" + "Occurances");
    // create a new array and store the user input
    int[]  newNumbers = new int[index];
    for (int i = 0; i < index; i++)
        newNumbers[i] = numbers[i];
    // sort the array
    for (int s = 0; s < newNumbers.length - 1; s++) {
        for (int j = 1; j < newNumbers.length - s; j++) {
            if (newNumbers[j - 1] < newNumbers[j]) {
                temp = newNumbers[j - 1];
                newNumbers[j - 1] = newNumbers[j];
                newNumbers[j] = temp;
            }
        }
    }
    System.out.println(Arrays.toString(newNumbers));
    int count = 1;
    int prevElement = 0;
    if (newNumbers.length > 0) {
        prevElement = newNumbers[0];
    }
     // print the results
    for (int x = 1; x < newNumbers.length; x++) {
        if (newNumbers[x] == prevElement) {
            count++;
        } else {
            System.out.println(prevElement + " occurs " + count + "times");
            prevElement = newNumbers[x];
            count = 1;
        }
    }
    System.out.println(prevElement + " occurs " + count + "times");

}