import java.io.*;
class FileRead 
{
 public static boolean main(String lineToCompare)
  {
  try{
  // Open the file that is the first 
  // command line parameter
  FileInputStream fstream = new FileInputStream("textfile.txt");

  // Get the object of DataInputStream
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));

  String strLine;
  //Read File Line By Line

  while ((strLine = br.readLine()) != null)   {
  //Compare the line with the line to compare (string)
  if(strLine.compareTo(lineToCompare) == 0)
      return true;
  }

  //Close the input stream
  in.close();
    }catch (Exception e){//Catch exception if any
     System.err.println("Error: " + e.getMessage());
  }

  return false;

  }
}