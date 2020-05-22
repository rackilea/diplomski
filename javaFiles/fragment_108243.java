public static void openCSV(String file) {
    FileInputStream fis;

    try {
        if (!(new File(file).exists())) {
            downloadCSV(file); //download it
        }
        fis = new FileInputStream(file);
        // should probably use the stream here, so you can close it in a finally clause linked to this try clause...
    } catch (FileNotFoundException e) { //file doesnt exist
        // Re-throw as a declared exception, a RuntimeException, and/or log it...
    } finally {
        if (fis != null) {
            try {
                fis.close();
            } catch (IOException ioe) {
                // write exception to logs or take other appropriate action...
            }
        }
    }
}