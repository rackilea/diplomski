import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScanFile {
    public static void main(String[] args)throws IOException {

        String newName=null;
        String newQuantity=null;
        boolean checked = true;

     File f= new File("E:\\myFile.txt");          // path to your file
     File tempFile = new File("E:\\myTempFile.txt"); // create a temp file in same path
     BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
     Scanner sc = new Scanner(f);
     System.out.println("Enter id of the record you want to edit?");
     Scanner sc2 = new Scanner(System.in);
     int id = sc2.nextInt();
     while(sc.hasNextLine())
     {
         String currentLine= sc.nextLine();
         String[] tokens = currentLine.split(" ");
         if(Integer.valueOf(tokens[0])==id && checked)
         {
             sc2.nextLine();                          
             System.out.println("New Name:");
             newName= sc2.nextLine();
             System.out.println("New Quantity:");
             newQuantity= sc2.nextLine();
             currentLine = tokens[0]+" "+newName+" "+newQuantity;
             checked = false;
         }
         writer.write(currentLine + System.getProperty("line.separator"));

     }
     writer.close(); 
     sc.close();
     f.delete();
     boolean successful = tempFile.renameTo(f);

    }
}