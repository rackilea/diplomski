String defaultEncoding = "UTF-8";
InputStream inputStream = new FileInputStream(someFileWithPossibleUtf8Bom);
try {
    BOMInputStream bOMInputStream = new BOMInputStream(inputStream);
    ByteOrderMark bom = bOMInputStream.getBOM();
    String charsetName = bom == null ? defaultEncoding : bom.getCharsetName();
    InputStreamReader reader = new InputStreamReader(new BufferedInputStream(bOMInputStream), charsetName);
    //use reader
} finally {
    inputStream.close();
}