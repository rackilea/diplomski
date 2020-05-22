public static void main(String[] args) {
    String secretWord = "frog";

    Map<Character, Integer> mapOfLetters = new HashMap<>();

    for (char c : secretWord.toCharArray()) {
        int count = 1;
        if (mapOfLetters.containsKey(c)) {
            count = mapOfLetters.get(c) + 1;
        }
        mapOfLetters.put(c, count);
    }

    System.out.println("Word has " + secretWord.length() + " letters.");
    System.out.println("Guess a letter: ");

    int correctGuesses = 0;

    int strikes = 5;

    Scanner input = new Scanner(System.in);

    while (strikes > 0 && !mapOfLetters.isEmpty()) {

        char guessedLetter = input.next().charAt(0);

        if (mapOfLetters.containsKey(guessedLetter)) {

            correctGuesses++;
            System.out.printf("Correct Guess! %d Letters Left!\n", secretWord.length() - correctGuesses);

            int count = mapOfLetters.get(guessedLetter) - 1;
            if (count == 0) {
                mapOfLetters.remove(guessedLetter);
            } else {
                mapOfLetters.put(guessedLetter, count);
            }
        } else {
            strikes--;
            System.out.printf("Incorrect: You Have %d Chances Left..\n", strikes);
        }
    }

    if (strikes == 0) {
        System.out.println("You Are Out of Chances! Game over!");
    } else if(mapOfLetters.isEmpty()){
        System.out.println("You Got It! The Word is: " + secretWord);
    }
}