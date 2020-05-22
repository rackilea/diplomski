pb = new ProcessBuilder("/bin/sh",script);
            pb.directory(new File(filePath));
            p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null){
               System.out.println(line);
               out.println(line);
               out.flush();
            }
            p.waitFor();
            System.out.println ("exit: " + p.exitValue());
            out.println("exit: " + p.exitValue());
            p.destroy();
            out.println("Script Executed");