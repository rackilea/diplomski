Word[] wordsArray = //Something

forContext(wordsArray, (previous, current, next) -> {

    //Do what you want with the function.
    System.out.println("The previous word: " + previous);
    System.out.println("The current word: " + current);
    System.out.println("The next word: " + next);

});