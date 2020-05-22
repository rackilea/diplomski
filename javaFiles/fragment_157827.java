String[] correctResults;
Random randomGenerator;

public void onCreate (Bundle savedInstanceState) {
    //All your init stuff...
    generator = new Random();
    correctResults = new String[] {"good job", "well done"};
}

public String getRandomCorrectResult() {
    return correctResults[generator.nextInt(correctResults.length)];
}