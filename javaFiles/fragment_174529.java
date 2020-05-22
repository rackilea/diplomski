Scanner keyboard = new Scanner(System.in);
System.out.print("Input File name: ");
String filename1 = keyboard.nextLine();
System.out.print("Output File name: ");
String filename2 = keyboard.nextLine();

File inputFile = new File(filename1);
File outputFile = new File(filename2);

Scanner infile = new Scanner(inputFile);
PrintWriter outputFile = new PrintWriter(outputFile);

Scanner lineScanner;

while(infile.hasNextLine()){             // here you read each line of a file
    String line = inFile.nextLine();     // here is a line

    lineScanner = new Scanner(line);     // for the above line, create a scanner 
                                         // just to scan that line
    while(lineScanner.hasNext()){        // loop through that line
        // do something
    }
}
outputFile.close();