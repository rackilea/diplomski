import org.apache.commons.io.IOUtils;

...

public static String readJsonFile(String filename) throws IOException {
    try (InputStream is = new FileInputStream(filename)) {
        return IOUtils.toString(is, StandardCharsets.UTF_8);
    }    
}

....

JSONArray array = new JSONArray(readJsonFile(jsonFilePath));