public static List<Double> getALInfo(Scanner in) {
    List<Double> inputs = new ArrayList<>();
    System.out.println("Please enter 5 - 10 integers, Q to quit: ");
    while (in.hasNextDouble()) {
        inputs.add(in.nextDouble());
    }
    in.next();
    return inputs;
}