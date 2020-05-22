static int findRepetition(int listOfValues[], int targetValue) {
    int i;
    int counter = 0;

    for (i = 0; i < listOfValues.length; i++) {
        if (listOfValues[i] == targetValue) {
            counter = counter + 1;
        }
    }
    return counter;
}

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int targetValue;
    int listOfValues[] = { 1, 6, 3, 8, 5, 8, 3, 4, 8, 3 };

    System.out.println("Please enter the desire number to look for: ");
    targetValue = input.nextInt();

    int counter = findRepetition(listOfValues, targetValue);

    if (counter != 0) {
        System.out.println("The frequency of the number " + targetValue + " is: " + counter);
    } else {
        System.out.println("The number " + targetValue + " is not contained     in the array list");
    }

}