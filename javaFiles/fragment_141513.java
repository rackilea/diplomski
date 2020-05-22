static void runProcessBuilderMulti (String cmd){

        System.out.println("Running Command: "+cmd.replace("\"","\\\""));

        try {
                Process process = new ProcessBuilder("/bin/sh", "-c", cmd).start();
                InputStream is = process.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line;

                while ((line = br.readLine()) != null) {
                        System.out.println(line);
                }

                System.out.println(process.exitValue());
        } catch (Exception e) {}
   }