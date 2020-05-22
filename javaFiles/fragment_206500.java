/** Import util for console input **/
import java.util.*;
import java.io.*;
/** Standard Public Declarations **/
public class costing
{
 public static void main(String[] args)
 {

  Scanner inFile;
  try {
     inFile = new Scanner(new FileReader("Coursework/input.txt"));
     String name = inFile.next();
     System.out.println(name);
} catch (FileNotFoundException ex) {
    ex.printStackTrace();
}
}
}