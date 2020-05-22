public double averageIncome() throws FileNotFoundException {
    File file = new File("Program10.txt");
    Scanner input = new Scanner(file);

    int numMuns = 0;
    int sum = 0;
    while (input.hasNext()) {

        numMuns++;

        // Just read id and ignore it
        input.nextInt();

        sum += input.nextDouble();

        // Just read # of Occupants and ignore it
        input.nextInt();

        //The next two lines are how I found the issue:
        System.out.println(numMuns);
        System.out.println(sum);

    }
    return sum / numMuns;
}