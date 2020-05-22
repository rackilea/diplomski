public static int guess (int numberOfGuesses, int secretNumber) {

    Scanner sc = new Scanner(System.in);

    for(int n = 1; n <= numberOfGuesses; n++){
        System.out.println("Guess "+n+" of "+numberOfGuesses+":");
        int userNumber = sc.nextInt();

        if(userNumber == secretNumber){
            return n;       
        }
    }
    return -1;
}