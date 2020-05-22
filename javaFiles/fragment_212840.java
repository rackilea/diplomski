// java.io.InputStream
InputStream inputStream = ClassLoaderUtil.getResourceAsStream("test.csv", YourCallingClass.class);
InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
BufferedReader reader = new BufferedReader(streamReader);
for (String line; (line = reader.readLine()) != null;) {
    // Process line
}