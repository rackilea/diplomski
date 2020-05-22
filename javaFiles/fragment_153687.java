...

String yourFileName = "C:\\yourFileName.txt";
PrintWriter outputStream = null;
try
{
    outputStream = new PrintWriter(yourFileName);
} 
catch (FileNotFoundException e) 
{
    System.out.println("Sorry, file not found.");
}