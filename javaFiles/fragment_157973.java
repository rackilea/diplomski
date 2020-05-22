// Why void? Just return the sum
public double readFile(String filename) {     
  Scanner input = null;
  double sum = 0;
  try {
    input = new Scanner(new File(filename));
    while (input.hasNextDouble()) {
      sum += input.nextDouble();
    }
    // output results
    System.out.printf("The total sum of the "
        + "doubles in the input file is %f\n", sum);
  } catch (FileNotFoundException e) {
    e.printStackTrace();
  } finally {
    input.close();
  }