import java.util.*;
import java.io.*;

public class FileLinkList
{
public static void main(String args[])throws IOException{
String content = new String();
int count=1;
File file = new File("abc.txt");
LinkedList<String> list = new LinkedList<String>();

 try {
Scanner sc = new Scanner(new FileInputStream(file));
while (sc.hasNextLine()){
content = sc.nextLine();
list.add(content);
}
sc.close();
}catch(FileNotFoundException fnf){
fnf.printStackTrace();
}
catch (Exception e) {
e.printStackTrace();
System.out.println("\nProgram terminated Safely...");
}

Collections.reverse(list);
Iterator i = list.iterator();
while (i.hasNext()) {
System.out.print("Node " + (count++) + " : ");
System.out.println(i.next());
}
 }
 }