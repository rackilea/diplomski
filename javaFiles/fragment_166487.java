while(userInput.indexOf("y")!=-1 || userInput.indexOf("Y")!=-1) {
        guessCount = playGame(reader);
        game++;
        System.out.println("Do you want to play again?");
        userInput = reader.next(); // read user answer
}