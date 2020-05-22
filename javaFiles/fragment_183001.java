try{
               Runtime rt = Runtime.getRuntime();
               Process proc = rt.exec("cmd /c netstat -ano | findstr 9090");

               BufferedReader stdInput = new BufferedReader(new
               InputStreamReader(proc.getInputStream()));
               String s = null;
               if ((s = stdInput.readLine()) != null) {
               int index=s.lastIndexOf(" ");
               String sc=s.substring(index, s.length());

               rt.exec("cmd /c Taskkill /PID" +sc+" /T /F");

       }
               JOptionPane.showMessageDialog(null, "Server Stopped");
         }catch(Exception e){
               JOptionPane.showMessageDialog(null, "Something Went wrong with server");
           }