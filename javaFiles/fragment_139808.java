try {
    FileOutputStream os = new FileOutputStream(file, true);
    out = new PrintStream(os, true, "UTF-8");
} catch (IOException e) {
    // TODO Auto-generated catch block
    fnf.printStackTrace();
}