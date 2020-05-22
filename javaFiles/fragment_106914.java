// Create new Scanner object to read from the keyboard
Scanner in = new Scanner(System.in);

// Grab the name of the file
System.out.println("Enter filename: ");
String fileName = in.next();

// Access the file
Scanner fileToRead = new Scanner(new File(fileName));

// Initialize our relevant counters
double sum = 0.0;
int numStudents = 0;

// While there is still stuff in the file...
while (fileToRead.hasNext()) { 
    // Is this next line consisting of just a number?
    if (fileToRead.hasNextDouble()) {
        // If it is, accumulate
        sum += fileToRead.nextDouble();
        numStudents++;
     } 
     else { // Else, just skip to the next line
         fileToRead.next();
     }   
}  
// Close the file when finished
fileToRead.close();

// Print the average:
System.out.println("The average mark is: " + (sum / numStudents));