public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int result = 0;

    System.out.println("Interactive quiz\n");
    System.out.println("Q1) Which country is new york located in?");
    System.out.println("    1) Canada");
    System.out.println("    2) United States");
    System.out.println("    3) China");
    System.out.println("    4) Russia");
    System.out.println("");
    System.out.print("> ");

    if(input.nextInt() == 2){
        System.out.println("Your answer is correct.");
        result++
    }else
        System.out.println("Your answer is incorrect.");

    System.out.println("");
    System.out.println("Q2) Which of these animals are not warm blooded?");
    System.out.println("    1) Bear");
    System.out.println("    2) Crow");
    System.out.println("    3) Elephant");
    System.out.println("    4) Frog");
    System.out.println("");
    System.out.print("> ");

    if (input.nextInt() == 4) {
        System.out.println("Your answer is correct.");
        result++;
    }else
        System.out.println("Your answer is incorrect.");

    System.out.println("");
    System.out.println("Q3) Which of these plants are carnivorous?");
    System.out.println("    1) Dandelion");
    System.out.println("    2) rafflesia");
    System.out.println("    3) cape sundew");
    System.out.println("    4) titan arum");
    System.out.println("");
    System.out.print("> ");

    if (input.nextInt() == 3) {
        System.out.println("Your answer is correct.");
        result++;
    }else
        System.out.println("Your answer is incorrect.");

    System.out.println("");
    System.out.println("Your final score is " + result + " out of 3.");
}