class MyEmbeddedDocumentExtractor implements EmbeddedDocumentExtractor extends ParsingEmbeddedDocumentExtractor{

private static int COUNT_LIMIT = 10;

...

@Override parseEmbedded(
            InputStream stream, ContentHandler handler, Metadata metadata, boolean outputHtml)
            throws SAXException, IOException {

 // separate the files in the InputStream

for(int i = 0; i < COUNT_LIMIT; i++){
        super.parseEmbedded(streamOfOneFile, handler, metadata, outputHtml)
    }
}

}