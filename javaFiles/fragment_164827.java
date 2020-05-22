public void readInQuarters () {
  Scanner input = new Scanner(System.in);
  System.out.println("Please enter Q1,Q2,Q3 and Q4 figures for broker:");
  quarter1 = input.nextInt(); // <-- Use your setters!
  quarter2 = input.nextInt();
  quarter3 = input.nextInt();
  quarter4 = input.nextInt();

  // should be,
  setQuarter1(input.nextInt()); // and so on... although I will point out, you should
                                // be reading double(s) apparently.
}