int arrayPos = 0;
do {
    // Input
    System.out.println("Student's age (Type -1 to end): ");

    // Set escapeNumber to what the user entered to break the while loop
    escapeNumber = input.nextInt();

    // Populate the array with the ages (Cannot be a negative number)
    if (escapeNumber > 0 && arrayPos < studentsAge.length) {
         studentsAge[arrayPos] = escapeNumber;
         arrayPos++
    }

} while (escapeNumber != -1 && arrayPos < studentsAge.length);