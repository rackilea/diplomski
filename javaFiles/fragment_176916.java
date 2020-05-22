public void newspaper() {
    Scanner in = new Scanner(System.in);
    System.out.println("Question 4 \n");
    double avg = 0;
    int sum = 0;
    int[] youths = new int[5];

    // The loop for calculating the average
    for (int i = 0; i < youths.length; i++) {
        System.out.println("Youth " + (i + 1) + " How many was delivered?");
        youths[i] = in.nextInt();

        sum = sum + youths[i];
    }
    // Note that the average can be calculated once, not every iteration
    avg = sum / youths.length;
    System.out.println("Average is: " + avg + "\n");

    // The loop for checking below of above average
    for (int i = 0; i < youths.length; i++) {
        if (youths[i] > avg) {
            System.out.println("Youth " + (i + 1) + " is above average");
        } else {
            System.out.println("Youth " + (i + 1) + " below average");
        }
    }

}