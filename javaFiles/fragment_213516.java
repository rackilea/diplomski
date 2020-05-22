private void game() {
    Random randomNumber = new Random();
    for(int i=0; i<diceRolls; i++) {
        results[i] = randomNumber.nextInt(6) + 1;
    }
    Arrays.sort(results);
}