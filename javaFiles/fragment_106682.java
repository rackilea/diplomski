private static final long ZIP_MAGIC_NUMBERS = 0x504B0304;
private static final String KMZ_CONTENT_TYPE = "application/vnd.google-earth.kmz";

private Document getDocument(String urlString) throws IOException, DocumentException, URISyntaxException {
        InputStream inputStream = null;
        URL url = new URL(urlString);
        String protocol = url.getProtocol();

        /*
         * Figure out how to get the XML from the URL -- there are 4 possibilities:
         * 
         * 1)  a KML (uncompressed) doc on the filesystem
         * 2)  a KMZ (compressed) doc on the filesystem
         * 3)  a KML (uncompressed) doc on the web
         * 4)  a KMZ (compressed) doc on the web
         */
        if (protocol.equalsIgnoreCase("file")) {
            // the provided input URL points to a file on a file system
            File file = new File(url.toURI());
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            long n = raf.readInt();
            raf.close();

            if (n == KmlMetadataExtractorAdaptor.ZIP_MAGIC_NUMBERS) {
                // the file is a KMZ file
                inputStream = new ZipInputStream(new FileInputStream(file));
                ((ZipInputStream) inputStream).getNextEntry();
            } else {
                // the file is a KML file
                inputStream = new FileInputStream(file);
            }

        } else if (protocol.equalsIgnoreCase("http") || protocol.equalsIgnoreCase("https")) {
            // the provided input URL points to a web location
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            String contentType = connection.getContentType();

            if (contentType.contains(KmlMetadataExtractorAdaptor.KMZ_CONTENT_TYPE)) {
                // the target resource is KMZ
                inputStream = new ZipInputStream(connection.getInputStream());
                ((ZipInputStream) inputStream).getNextEntry();
            } else {
                // the target resource is KML
                inputStream = connection.getInputStream();
            }

        }

        Document document = new SAXReader().read(inputStream);
        inputStream.close();

        return document;
    }