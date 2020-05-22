grades() {

    Scanner in = new Scanner(System.in);
    System.out.println("How many grades would you like to enter? "); //user input how many grades user would like to enter
    int q = in.nextInt();

    double[] grades = new double[q]; //initialized array
    double sum = 0;
    for (int counter = 0; counter < q; counter++){ //user enters # of grades they requested to enter
        System.out.println("Enter your grades: ");
        double grade = in.nextInt();
        grades[counter] = grade; //grade values stored in array
    }

    int minInterval = 0;
    int maxInterval = 9;
    // you should loop for each interval
    while (maxInterval < 100) {
        System.out.print(minInterval + "-" + maxInterval + ":"); //print those grades on graph
        // print one asteriks for each grade falls in range
        for (int i = 0; i < q; i++){ //loop scans grades. Iterate through the grades array with filled values
            if (minInterval <= grades[i] && grades[i] <= maxInterval ) { //if grades stored in array fall within range
                System.out.print("*");
            }
        }
        System.out.println();
        minInterval += 9;
        maxInterval += 9;
    }

}