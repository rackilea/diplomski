public double honorsCalculation() throws IOException {
    Scanner test = new Scanner(new File("Calculus - Test.txt"));
    ArrayList <Double> assignments = new ArrayList <Double> ();
    while (test.hasNext()) {
        double num = test.nextDouble();
        assignments.add(num);
    }
    for (int i = 1; i < assignments.size() - 1; i++) {
        sum = sum + assignments.get(i);
        percentage = sum;
    }
    return percentage;
}