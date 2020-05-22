try {
    ProcessBuilder pb = new ProcessBuilder("/bin/chmod", "777", path);    
    pb.redirectErrorStream(true); // merge stdout, stderr of process

    Process p = pb.start();
    InputStreamReader isr = new  InputStreamReader(p.getInputStream());
    BufferedReader br = new BufferedReader(isr);

    String lineRead;
    while ((lineRead = br.readLine()) != null) {
        // swallow the line, or print it out - System.out.println(lineRead);
    }

    int rc = p.waitFor();
    // TODO error handling for non-zero rc
}
catch (IOException e) {
    e.printStackTrace(); // or log it, or otherwise handle it
}
catch (InterruptedException ie) {
    ie.printStackTrace(); // or log it, or otherwise handle it
}