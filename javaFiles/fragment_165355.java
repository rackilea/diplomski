public class LoadStringUtility {

    public static String loadStringFromFile(String file) throws IOException {
        InputStream inputStream = LoadStringUtility.class.getClassLoader().getResourceAsStream(file);
        return IOUtils.toString(inputStream);
    }
}