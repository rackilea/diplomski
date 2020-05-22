public static byte[] convertToDatabaseColumn(String text) throws IOException {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
         Writer out = new OutputStreamWriter(
                 new GZIPOutputStream(baos), StandardCharsets.UTF_8)) {
        out.write(text);
        out.write("\n");
        out.close();
        return baos.toByteArray();
    } catch (IOException e) {
        throw new UncheckedIOException(e);
    }
}

public static String convertToEntityAttribute(byte[] dbData) throws IOException {
    try (BufferedReader br = new BufferedReader(
            new InputStreamReader(
                    new GZIPInputStream(new ByteArrayInputStream(dbData)),
                    StandardCharsets.UTF_8))) {

        return br.readLine();
    } catch (IOException e) {
        throw new UncheckedIOException(e);
    }
}

public static void main(String[] args) throws IOException {
    byte[] bytes = convertToDatabaseColumn("Hello world, 0123456789 0123456789");
    System.out.println(convertToEntityAttribute(bytes));
}