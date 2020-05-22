import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestClass {    
  static public void main(String[] args) {
    File file = new File("myfile.txt");
    String[] lines = new String[10];
    try {
        FileReader reader = new FileReader(file);
        BufferedReader buffReader = new BufferedReader(reader);
        int x = 0;
        String s;
        while((s = buffReader.readLine()) != null){
            lines[x] = s;
            x++;
        }
    }
    catch(IOException e){
        //handle exception
    }
    // And just to prove we have the lines right where we want them..
    for(String st: lines)
    System.out.println(st);
  }
}