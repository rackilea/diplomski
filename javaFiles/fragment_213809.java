Set<Integer> guessedNumbers = new HashSet<Integer>();
if(guessedNumbers.contains(guess)){
    System.out.println("You already guessed this earlier");
}
else{
    guessedNumbers.add(guess);
}