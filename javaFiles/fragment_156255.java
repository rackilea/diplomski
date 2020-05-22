while (win == false){
//need one at the beginning 

        System.out.println("Guess the number (1 - 20)");
        int guess = scan.nextInt();
        numberOfAttempts++;

        if (guess == random)
            win = true;
        else if (guess < random)
            System.out.println("Your guess was low. Guess again.");
        else
            System.out.println("Your guess was high. Guess again.");
} //and at the end