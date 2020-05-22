int sum = 0;
    double average;
    Scanner userInputScanner = new Scanner(System.in);

    System.out.println("Please enter the integers with space between each two integer: ");
    String inputNumberFilePath = userInputScanner.nextLine();

    String[] numStrArray = inputNumberFilePath.split(" ");

    for (String string : numStrArray) {
        sum += Integer.parseInt(string);
    }

    average = (double) sum / (double) numStrArray.length;
    System.out.println("Sum: " + sum);
    System.out.println("Average: " + average);