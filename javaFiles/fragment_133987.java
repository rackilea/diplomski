private boolean run(boolean runAsRoot, String cmd) {

    String shell = runAsRoot ? "su" : "sh";

    int exitCode = 255;
    Process p;
    try {

        p = Runtime.getRuntime().exec(shell);
        DataOutputStream os = new DataOutputStream(p.getOutputStream());

        os.writeBytes(cmd + "\n");
        os.flush();

        os.writeBytes("exit\n");
        os.flush();

        exitCode = p.waitFor();

    } catch (IOException e1) {
            Log.e("Exception", e1.toString());
    } catch (InterruptedException e) {
            Log.e("Exception", e.toString());
    }
    return (exitCode != 255);
}    

public boolean copyFile() {
    return run(true, "busybox cp /data/data/com.my.test.app/databases/ /mnt/sdcard/testapp/");
}