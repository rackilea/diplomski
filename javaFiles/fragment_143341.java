int total = 0;
int number;

try {
    File inFile = new File("intnumbers.txt");
    Scanner fileScanner= new Scanner(inFile);
    while (fileScanner.hasNext())
    {
        if(fileScanner.hasNextInt()) // Check for an valid integer
        {
            number = fileScanner.nextInt(); // Gets the integer
            total = total + number;         // Add it to the total
            System.out.println(number);
        }
        else
        {
            fileScanner.next(); // Skip invalid input
            // System.out.println("Data incorrect type, expecting an int");
        }
    }
    fileScanner.close();
}
catch (FileNotFoundException e) {
    System.err.println("No such file name");
}
catch (InputMismatchException e)
{
    // If an exception is thrown for an invalid data type
    // Your loop will not run to completion
    System.err.println("Data incorrect type expecting an int");
}

System.out.println("Finished");
System.out.println("Total is:" + total);