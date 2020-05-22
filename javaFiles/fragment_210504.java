public byte[] convertToDatabaseColumn(String text) {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
         Writer out = new OutputStreamWriter(
                      new GZIPOutputStream(baos), StandardCharsets.UTF_8))) {
        out.write(text);
        out.close();    
        return baos.toByteArray();
    } catch (IOException e) {
        throw new UncheckedIOException(e);
    }
}

public String convertToEntityAttribute(byte[] dbData) {
    try (Reader reader = new InputStreamReader(
                         new GZIPInputStream(new ByteArrayInputStream(dbData)),
                         StandardCharsets.UTF_8) {

        char[] chars = new char[512];
        StringBuilder sb = new StringBuilder();
        for (int len; (len = reader.read(chars)) > 0;)
            sb.append(chars, 0, len);

        return sb.toString();
    } catch (IOException e) {
        throw new UncheckedIOException(e);
    }
}