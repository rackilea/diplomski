long tm=System.currentTimeMillis();
try {
  String cmd="cmd /c dir c:\\  /s  ";
  execute(cmd, false);
}
catch (Exception ex) { }
  System.out.println((System.currentTimeMillis()-tm));


public String execute(String cmd, boolean getoutput) {
String output=null;
  try {
    Runtime rt = Runtime.getRuntime();
    Process pr=rt.exec(cmd);
    StreamGobbler errorGobbler=new StreamGobbler(pr.getErrorStream(), "ERROR", getoutput);
    errorGobbler.start();
    StreamGobbler inputGobbler=new StreamGobbler(pr.getInputStream(), "INPUT", getoutput);
    inputGobbler.start();
    int exitVal=pr.waitFor();
    System.out.println("ExitValue: " + exitVal);
    output=""+errorGobbler.output;
    output+=inputGobbler.output;
  }
  catch(Throwable t) { t.printStackTrace(); }
  return output;
}


import java.util.*;
import java.io.*;

public class StreamGobbler extends Thread {
boolean redirect=false;
InputStream is;
OutputStream os;
String type, output="";

StreamGobbler(InputStream is, String type) {
    this.is = is;
    this.type = type;
}

StreamGobbler(InputStream is, String type, boolean redirect) {
    this.is = is;
    this.type = type;
    this.redirect=redirect;
}

StreamGobbler(OutputStream os, String type) {
    this.os = os;
    this.type = type;
}

StreamGobbler(OutputStream is, String type, boolean redirect) {
    this.os = os;
    this.type = type;
    this.redirect=redirect;
}

 public void run() {
    try
    {
        if(type.equals("OUTPUT")) {
        }
        else {
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line=null;
        int i=0;
        while ( (line = br.readLine()) != null) {
            if(redirect) output+=line;
            else System.out.println("line "+i+" "+type + ">" + line);
            i++;
        }
        }
        } catch (IOException ioe)
          {
            ioe.printStackTrace();
          }
}   

}