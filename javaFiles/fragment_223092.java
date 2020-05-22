public static void printStream(InputStream is, String type){
try
   {
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
      String line=null;
      while ( (line = br.readLine()) != null)
            System.out.println(type + ">" + line);    
   } catch (IOException ioe){
           ioe.printStackTrace();  
   }
}

public static void main(String args[])
{
    String cmd = "command to execute";
    Process proc = Runtime.getRuntime().exec(cmd);
    printStream(proc.getInputStream(), "OUTPUT");
    printStream(proc.getErrorStream(), "ERROR");
}