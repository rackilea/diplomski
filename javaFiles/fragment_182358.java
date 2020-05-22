import java.io.*;

class CorrectFile 
{
  public static void main(String[] args) 
  {
    FileReader fr = null;
    String line = "";
    String result="";
    // open the file
    try {
      fr = new FileReader("file.txt");
    } catch (FileNotFoundException e) {
        System.out.println("Can not open the file!");
        System.exit(1);
    }

    BufferedReader bfr = new BufferedReader(fr);
    // read the lines:
    try {
         while((line = bfr.readLine()) != null){
            line = line.trim().replaceAll("\\s*([,,.])\\s*", "$1 ");
            System.out.println(line);
        }
    } catch (IOException e) {
        System.out.println("Can not read the file!");
        System.exit(2);
   }

   // close the file
   try {
     fr.close();
   } catch (IOException e) {
     System.out.println("error can not close the file");
     System.exit(3);
   }
  }
}