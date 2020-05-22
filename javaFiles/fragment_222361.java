try {
    String cmd="/progs/my/prog //10.124.12.15/C:/output/* /temp/input/345 -N -A" 
    Runtime runtime = Runtime.getRuntime();
    Process proc = runtime.exec(
       new String[]{"/usr/bin/bash", "-c", cmd, "1>/dev/null 2>&1"});    
    proc.waitFor();
} catch (IOException ex) {
    ex.printStackTrace();
} catch (InterruptedException ex) {
    ex.printStackTrace();
}