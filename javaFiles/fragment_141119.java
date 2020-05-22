public String compile()
       {
           String log="";
            try {
                String s= null;
              //change this string to your compilers location
            Process p = Runtime.getRuntime().exec("cmd /C  \"C:\\Program Files\\CodeBlocks\\MinGW\\bin\\mingw32-g++.exe\" temp.cpp ");

            BufferedReader stdError = new BufferedReader(new 
                 InputStreamReader(p.getErrorStream()));
            boolean error=false;

            log+="\n....\n";
            while ((s = stdError.readLine()) != null) {
                log+=s;
                error=true;
                log+="\n";
            }
            if(error==false) log+="Compilation successful !!!";

        } catch (IOException e) {
            e.printStackTrace();
        }
            return log;
       }


     public int runProgram() 
       {
           int ret = -1;
          try
            {            
                Runtime rt = Runtime.getRuntime();
                Process proc = rt.exec("cmd.exe /c start a.exe");
                proc.waitFor();
                ret = proc.exitValue();
            } catch (Throwable t)
              {
                t.printStackTrace();
                return ret;
              }
          return ret;                      
       }