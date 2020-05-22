public void tail(String file) throws InterruptedException, IOException {
    boolean isNeedRun = true;
    while (isNeedRun) {
        waitUntilFileExist(file);
        try {
            readFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

private void readFile(String file) throws InterruptedException, IOException {
    File f = new File(file);

    FileReader reader = new FileReader(file.trim());
    try {
        BufferedReader br = new BufferedReader(reader);
        br.skip(f.length());
        String line;

        while (f.exists()) {

            f = new File(file);
            line = br.readLine();

            if (line == null) {

                Thread.sleep(1000);

            } else {
                if (msl != null) {
                    //Send line to attached interface
                    msl.onMessage(line);
                }
            }
        }
    } finally {
        try {
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

private void waitUntilFileExist(String file) throws InterruptedException {
    File f = new File(file);
    while (!f.exists()) {
        System.out.println("File doesn't exists");
        Thread.sleep(1000);
    }
    System.out.println("File does exists");
}