import java.util.*;
   import java.io.*;



  public class MyFunction {
 public static void main(String args[])
 throws IOException, ClassNotFoundException
 {


 //variable initialization

String strLine;

 //Read in a file and process one line at a time

   FileReader singleFile = new FileReader("C:\\data\\data.txt");  
   BufferedReader reader = new BufferedReader(singleFile);

    for (int i=0; i<12; i++) {
    FileWriter outFile = new FileWriter("C:\\sample\\doc" + i + ".txt");
    BufferedWriter writer = new BufferedWriter(outFile);     

    //Read one line at a time from the input file
    if ((strLine = reader.readLine()) !=null) 
    //process a string which is not empty

    if (strLine.length() > 0) {

    System.out.println("This is strLine: " + strLine);
    writer.write (strLine);

    System.out.println("This is i: " + i);

    } //end of if


  singleFile.close();
  writer.close();

    } }}