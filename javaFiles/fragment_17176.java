// Retrieve the interval the user wants to see
    Scanner s = new Scanner(System.in);
    System.out.println("Enter the interval for the histogram (e.g. '0 100'):");
    int lowerBound = s.nextInt();
    int upperBound = s.nextInt();

    // Print the histogram title and 'column headers'
    System.out.println();
    System.out.println("HISTOGRAM");
    System.out.println("Grade\tFrequency");

    // For each grade present in the interval, print out its 'label'
    // (the assigned grade)
    for (int i = lowerBound; i < upperBound; i++) {
        System.out.print(i + "\t");

        // For each time this grade was assigned to a student,
        // print an asterisk
        for (int j = 0; j < gradeFrequency[i]; j++) {
            System.out.print("*");
        }
        System.out.println();
    }