try {
    FileOutputStream os = new FileOutputStream(file, true);
    out = new PrintStream(os, true, "UTF-8");
} catch (UnsupportedEncodingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (FileNotFoundException fnf) {
    // TODO Auto-generated catch block
    fnf.printStackTrace();
}