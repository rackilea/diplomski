import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

  public static void main(String[] args){

    try (BufferedReader reader = Files.newBufferedReader(Paths.get("./testfile.txt"), StandardCharsets.UTF_8)){

      int lineNr = 0;
      String line;

      while((line = reader.readLine()) != null){
        lineNr++;
        int spaces = 0;
        for (int i=0;i<line.length();i++){
          if (line.charAt(i) == ' '){
            spaces++;
          }
          else{
            break;
          }
        }

        System.out.println("line "+lineNr+" has "+spaces+" leading spaces:"+line);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}