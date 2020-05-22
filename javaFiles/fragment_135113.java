public static void grades(){
    Scanner in = new Scanner(System.in);
    System.out.println("How many grades would you like to enter? "); //user input how many grades user would like to enter
    int q = in.nextInt();

    double[] grades = new double[q];
    double sum = 0;
    for (int counter = 0; counter < q; counter++){ //user enters # of grades they requested to enter
        System.out.println("Enter your grades: ");
        double grade = in.nextInt();
        grades[counter] = grade;
        sum += grade;
    }
    double mean = sum / q;
    System.out.println("Mean: " + mean);
    for (int i = 0; i < q; i++){ //loops prints grades less than mean
        if (grades[i] < mean) {
            System.out.println(grades[i]);
        }
    }
}