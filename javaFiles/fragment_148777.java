String defaultEncoding = "UTF-8";
InputStream inputStream = new FileInputStream(file);

try
{
    BOMInputStream bOMInputStream = new BOMInputStream(inputStream);
    ByteOrderMark bom = bOMInputStream.getBOM();
    String charsetName = bom == null ? defaultEncoding : bom.getCharsetName();

    InputStreamReader reader = new InputStreamReader(new BufferedInputStream(bOMInputStream), charsetName);
    // your code...
}
finally
{
    inputStream.close();
}