boolean flag = true;   // initialize flag with true value;

do{   
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter your guess number between 0 and 10 ====>");
    int guessedNumber = input.nextInt();

    if(guessedNumber > realNumber){
        System.out.println("My number is lower than " + guessedNumber + " guess lower!");

    }else if(guessedNumber < realNumber){
        System.out.println("My number is higher than " + guessedNumber + " guess higher!");
    }else{
        System.out.println("Yes! That's my number!");
        flag = false;   // when condition satisfies change the flag to false to break the loop.
    }
}while(flag)