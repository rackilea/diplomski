try {
         String command = "asadmin list-instances --long=true";
         Process p = Runtime.getRuntime().exec(command);
         BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
         for (String s = br.readLine(); s != null; s = br.readLine()) {
                System.out.println("line: " + s);
         }
         br.close();
         p.waitFor();
         System.out.println("command executed exited: " + p.exitValue());
         p.destroy();
    } catch (Exception e) {
        System.out.println("Exception" + e);
    }