private String getContent(File file) throws IOException {
    StringWriter writer = new StringWriter();
    IOUtils.copy(new FileInputStream(file), writer, "UTF-8");
    String result = writer.toString();
    return result;
}