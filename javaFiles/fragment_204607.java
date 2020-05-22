ArrayList<Integer> guesses = new ArrayList<>();
for(int i =0; i < 100; i++) {
  guesses.add(i);
}
//guesses now contains numbers 0-99
Collections.shuffle(guesses);