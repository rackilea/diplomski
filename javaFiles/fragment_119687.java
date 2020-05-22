public static void triggerOpenSaveCloseScript(String file) {

    String projPath = System.getProperty("user.dir");
    String script = projPath + "\\Script\\excelOpenSave.vbs";
    String command = "CScript " + script + "  " + file;
    int exitValue = 0;
    try {
        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec(command);
        exitValue = pr.waitFor(); //wait until script finishes
    } catch (IOException e) {
        e.printStackTrace();
    } catch (InterruptedException e) {
        System.out.println("CScript exited with error: " + exitValue);
        e.printStackTrace();
    }
}