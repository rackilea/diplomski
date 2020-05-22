BufferedInputStream bIS = new BufferedInputStream(
fileResourceStream);
try {
        BufferedOutputStream bOS = new BufferedOutputStream(
        new FileOutputStream(Globals.applicationDirPath
                + Globals.exeFileName, false));

        int BUFFER_SIZE = 4096;
        byte[] buff = new byte[BUFFER_SIZE];
        int bytesRead = bIS.read(buff, 0, BUFFER_SIZE);
        while (bytesRead >= 0) {
            bOS.write(buff, 0, bytesRead);
            bytesRead = bIS.read(buff, 0, BUFFER_SIZE);
        }
        bIS.close();
        bOS.flush();
        bOS.close();
}// try {
catch (Exception e) {
        Globals.log("Exception in checkAndCopyClientToMemory."
        + e.toString());
}