public static ArrayList<Double> getNumbers(final Scanner in) {
    System.out.println(
      "Please enter five to ten numbers all on one line " +
      "separated with spaces."
    );
    final String s = in.nextLine();
    final Scanner parser = new Scanner(s);
    ArrayList<Double> inputs = new ArrayList<>();
    while (parser.hasNextDouble()) {
        inputs.add(parser.nextDouble());
    }
    parser.close();
    return inputs;
}