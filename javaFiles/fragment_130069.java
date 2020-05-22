import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public static void main(String[] args) {

  try {
      FileInputStream in = new FileInputStream("inputFile.txt");
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String strLine;

      while((strLine = br.readLine())!= null) {
          addItem(strLine);
      }

  } catch(Exception e) {
      System.out.println(e);
  }

}