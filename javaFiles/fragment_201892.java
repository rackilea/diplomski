char result = determineWinner(); //Play the game and get the result

// use it in conditions

if (result == 'a') {  
    System.out.println("The computer wins!");
    System.out.println("");
    computerWins++;
}

else if (result == 'b') {
    System.out.println("The user wins!");
    System.out.println("");
    userWins++;
}

else if (result == 'c'){
    System.out.println("The game is tied!");
    System.out.println("");
    ties++;
}

else {
    error++;
}