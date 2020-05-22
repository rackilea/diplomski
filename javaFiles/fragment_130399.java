public String makeSolution() {
    Random randGen = new Random();
    final StringBuilder sb = new StringBuilder();
    final String symbols = "YORBGP";

    for (int i = 0; i < NUM_OF_PEGS; i++) {
        int index = randGen.nextInt(symbols.length());
        sb.append(symbols.charAt(index));
    }

    return sb.toString();
}