InputStream fis = getResources().openRawResource(R.raw.checkit);
try {
    byte[] buffer = new byte[4096]; // 4K buffer
    int len = 0;
    while((len = fis.read(buffer)) != -1) {
        test += new String (buffer, 0, len);
    }
    testing = test;
} catch (IOException ioe) {
    ioe.printStackTrace();
    // make sure you do any other appropriate handling.
} finally {
    fis.close();
}