public static void CompileCprog(String filename){

        File dir = new File("C://Users//JohnDoe//workspace//Project");

        try {  
            String exeName = filename.substring(0, filename.length() - 2);
            Process p = Runtime.getRuntime().exec("cmd /C gcc " + filename + " -o " + exeName, null, dir);  
            Process p = Runtime.getRuntime().exec("cmd /C dir", null, dir);  
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));  
            String line = null;  
            while ((line = in.readLine()) != null) {  
                System.out.println(line);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }   
    }