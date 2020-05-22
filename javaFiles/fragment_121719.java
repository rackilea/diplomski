public static void rebootSU() {
    Runtime runtime = Runtime.getRuntime();
    Process proc = null;
    OutputStreamWriter osw = null;
    StringBuilder sbstdOut = new StringBuilder();
    StringBuilder sbstdErr = new StringBuilder();

    String command="/system/bin/reboot";

    try { // Run Script

        proc = runtime.exec("su");
        osw = new OutputStreamWriter(proc.getOutputStream());
                            osw.write(command);
                osw.flush();
        osw.close();

    } catch (IOException ex) {
        ex.printStackTrace();
    } finally {
        if (osw != null) {
            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();                    
            }
        }
    }
    try {
        if (proc != null)
            proc.waitFor();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    sbstdOut.append(ReadBufferedReader(new InputStreamReader(proc
            .getInputStream())));
    sbstdErr.append(ReadBufferedReader(new InputStreamReader(proc
            .getErrorStream())));
    if (proc.exitValue() != 0) {
                }
        }