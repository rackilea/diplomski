public class Command {

public static void main(String[] args) throws java.io.IOException, InterruptedException {
       String path = "C:\\Users\\andreas";

       Process p = Runtime.getRuntime().exec("cmd /c start /wait " + path + "\\RunFromCode.bat");

       System.out.println("Waiting for batch file ...");
       p.waitFor();
       System.out.println("Batch file done.");
   }
}