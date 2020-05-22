Process p;
    String execBatchPath = "your file path";

    try {
        p = Runtime.getRuntime().exec("cmd /c start " + execBatchPath);
        p.waitFor();
    } catch (IOException e) {
        FileIO.writeLog("IO exception while trying to run the batch");
        ErrorUtils.manageCatch(e);
    } catch (InterruptedException e) {
        FileIO.writeLog("Batch process was interrupted");
        ErrorUtils.manageCatch(e);
    }