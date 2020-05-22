public static void main(String[] args) throws IOException, InterruptedException {
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("cmd /c netstat -ano | findstr 8080");
            //for linux
            //Process proc = rt.exec("/bin/bash -c netstat -ano |grep 8080");

            BufferedReader bufferedReader = new BufferedReader(new
                    InputStreamReader(proc.getInputStream()));
            String line = null;
            System.out.println("<OUTPUT>");
            if ((line = bufferedReader.readLine()) != null) {
                int processIdString = line.lastIndexOf(" ");
                String processId = line.substring(processIdString, line.length());
                System.out.println("Your process Id to Kill : " + processId);
                rt.exec("cmd /c Taskkill /PID" + processId + " /T /F");
                //for linux
                //rt.exec("/bin/bash -c kill -9 "+processId);

            }
            System.out.println("<OUTPUT>");
        } catch (Exception e) {
            System.out.println("Error Occured");
        }
    }