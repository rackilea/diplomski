package test1;
 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStream;
 import java.io.InputStreamReader;
 public class ProcessCommanLine {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ProcessCommanLine batchExecuteService = new ProcessCommanLine();
        ProcessCommanLine.run();
    }

    static void run() {
        // TODO Auto-generated method stub
        try {
            String cmds[] = {"D:\\test1.bat"};
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(cmds);
            process.getOutputStream().close();
            InputStream inputStream = process.getInputStream();
            InputStreamReader inputstreamreader = new InputStreamReader(inputStream);
            BufferedReader bufferedrReader = new BufferedReader(inputstreamreader);
            String strLine = "";
            while ((strLine = bufferedrReader.readLine()) != null) {
               // System.out.println(strLine);
                String ph="Physical Address";
                String subtring=null;
                if(strLine.length()>ph.length())
                subtring=strLine.substring(3,ph.length()+3); 
               if(strLine.contains(ph))
               {    
                   int i=strLine.indexOf(":")+1;
                   System.out.println(strLine.substring(i, strLine.length()));

               }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}