public static boolean createDirIfNotExists(String path) {
    boolean ret = true;

    File file = new File(Environment.getExternalStorageDirectory(), path);
    if (!file.exists()) {
        if (!file.mkdirs()) {
            Log.e("TravellerLog :: ", "Problem creating Image folder");
            ret = false;
        }
    }
    return ret;
}