StringWriter stringWriter = new StringWriter();
m.marshal(element, stringWriter);
String content = stringWriter.toString();
try (BufferedWriter writer = Files.newBufferedWriter(hfile, 
        Charset.forName("ISO-8859-15"))) {
    writer.write(content);
}