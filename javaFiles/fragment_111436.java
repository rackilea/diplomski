public static String[] getStringArray(String filename)
{
    try { return IOUtils.toString(new FileInputStream(filename), Charset.defaultCharset()).split("(\\\\n|\\r?\\n)"); }
    catch (IOException ex) { Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex); }
    return null;
}