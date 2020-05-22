final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
final DocumentBuilder builder = factory.newDocumentBuilder();

final Document document;

try (
    final InputStream in = resource.getInputStream();
) {
    document = builder.parse(in);
}

// work with document