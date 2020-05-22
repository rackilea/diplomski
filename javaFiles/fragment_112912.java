String path = Environment
        .getExternalStorageDirectory()
        + File.separator
        + "Phoenix" + File.separator + "default";

if (new File(path).mkdirs()) {
    OutputStream outFile;
    String fileName = "" + System.currentTimeMillis() + ".jpg";
    File file = new File(path, fileName);        
    ...
}