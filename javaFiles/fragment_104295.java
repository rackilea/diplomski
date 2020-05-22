do{
    java.util.Date date= new java.util.Date();

    // Initialize variable and store new Timestamp object
    Timestamp timestamp = new Timestamp(date.getTime()));

    System.out.print(timestamp)
    lineToPrint = myScanner.nextLine();

    // Concatenate the two variables
    printToFile (fileName, timestamp + " " + lineToPrint);


} while (!lineToPrint.equalsIgnoreCase("q") );