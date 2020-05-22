public static JsonObject readFile(String path)
{
    InputStream is = new FileInputStream(path);
    JsonReader rdr = Json.createParserFactory(null).createReader(is, java.nio.charset.StandardCharsets.UTF_8);
    JsonObject obj = rdr.readObject();
    rdr.close();
    return obj;
}