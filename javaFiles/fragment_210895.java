try {
    Scanner input = new Scanner (file);

    // input.hasNextLine() checks if there are more lines that can be read from
    // the file. If there is a line, hasNextLine() will return true, and the code
    // inside the while block will be executed.
    // Then execution will come back here to perform the check again. This
    // goes on until there are no more lines to consume.
    while (input.hasNextLine()) {

        // We are going to read two numbers from file.
        // Ideally, we should check if there a line available before reading
        // each of these lines. But since you confirm that the file will
        // always have multiple number of triplets containing two lines
        // with numbers, followed by a blank line, we are not going to
        // call input.hasNextLine() here.
        String number1 = input.nextLine();
        String number2 = input.nextLine();

        // Now, two numbers are read, read the next (empty) line to a variable
        // but we will not use it anywhere.
        String emptyLine = input.nextLine();
        // ...or we could read it, but just discard it without assigning it to a variable
        // input.nextLine();

        // Print what we read to the output, like a boss.
        System.out.println("String: " + number1);
        System.out.println("String: " + number2);
        System.out.println(number1 + " " + number2);

        // This is not needed here (see below to understand why):
        //number1= input.nextLine();
        //number2= input.nextLine();

        // after the following brace (}), execution will go back to the start
        // of the while loop. and if there are more lines to be read, code
        // inside while loop will be executed again.
    }
}