do{
    java.util.Date date= new java.util.Date();
    System.out.print(new Timestamp(date.getTime()));


    lineToPrint = myScanner.nextLine();

    printToFile (fileName, lineToPrint);


} while (!lineToPrint.equalsIgnoreCase("q") );