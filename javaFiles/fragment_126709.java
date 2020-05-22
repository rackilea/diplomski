public static void main(String[] args)  {
    int numberOfSquares;
    Scanner input = new Scanner(System.in);
    System.out.print("Type number of asterixes to make the square: ");
    numberOfSquares = input.nextInt();
             //omitted declaration of count1 here
    int count2 = 1;
    while (count2 <= numberOfSquares) {
        int count1 = 1; //declaring and resetting count1 here
        while (count1 <= numberOfSquares) {
            System.out.print("*");
            count1++;
        }
        System.out.println();
        count2++;
    }
}