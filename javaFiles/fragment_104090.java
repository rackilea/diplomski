for(i = 0; i < numberOfProjects; ++i) {
    projectBoardFootageTotal = 0.0;
    while (projectBoardFootage > 0) {
        System.out.println("Enter your board footage for Project #" + (i + 1) + " (0 to exit)");
        projectBoardFootage = scan.nextDouble();
        projectBoardFootageTotal += projectBoardFootage;
    }
    System.out.println("The raw board footage for Project #" + (i + 1) + " is: " + projectBoardFootageTotal);
}