static Collection<String> getLinks(Path file)
throws IOException,
       MimeTypeParseException,
       BadLocationException {

    HTMLEditorKit htmlKit = new HTMLEditorKit();

    HTMLDocument htmlDoc;
    try {
        htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();
        try (Reader reader =
            Files.newBufferedReader(file, StandardCharsets.ISO_8859_1)) {

            htmlKit.read(reader, htmlDoc, 0);
        }
    } catch (ChangedCharSetException e) {
        MimeType mimeType = new MimeType(e.getCharSetSpec());
        String charset = mimeType.getParameter("charset");

        htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();
        htmlDoc.putProperty("IgnoreCharsetDirective", true);
        try (Reader reader =
            Files.newBufferedReader(file, Charset.forName(charset))) {

            htmlKit.read(reader, htmlDoc, 0);
        }
    }

    Collection<String> links = new ArrayList<>();

    for (HTML.Tag tag : Arrays.asList(HTML.Tag.LINK, HTML.Tag.A)) {
        HTMLDocument.Iterator it = htmlDoc.getIterator(tag);
        while (it.isValid()) {
            String link = (String)
                it.getAttributes().getAttribute(HTML.Attribute.HREF);

            if (link != null) {
                links.add(link);
            }

            it.next();
        }
    }

    return links;
}