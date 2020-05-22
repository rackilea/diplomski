private static File getFinalDir() {
    return createDirIfNotExist(Environment.getExternalStorageDirectory().getPath() + "/MyAppName/");
}


public static File createDirIfNotExist(String path) {
    File dir = new File(path);
    if (!dir.exists()) {
        dir.mkdirs();
    }
    return dir;
}