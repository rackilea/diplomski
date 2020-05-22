public String deviceUDID() throws IOException{
        ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c", "/usr/local/bin/idevice_id -l");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        line = r.readLine();
        System.out.println(line);
        return line;
    }