import java.io.*;
BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("Path"))));
String line = null;
while((line = br.readLine()) != null){
    System.out.println(line.substring(line.indexOf(" ") + 1));
}
br.close();