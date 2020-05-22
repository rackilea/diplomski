Set<Character> guesses = new HashSet<Character>();
//...
char guessedLetter = Input.next().charAt(0);

if (guesses.contains(guessedLetter)) {

    System.out.println("You've used this guess, guess again");

} else {

    guesses.add(guessedLetter);