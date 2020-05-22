for( String curFile : xmlFiles )
{
        ZipFile zip = new ZipFile(new File( dirToProcess + curFile));
        Enumeration<? extends ZipEntry> entries = zip.entries();
        while (entries.hasMoreElements()){
            ZipEntry entry = entries.nextElement();
            InputStream xmlStream = zip.getInputStream(entry);
            saxParser.parse( xmlStream, handler );
            xmlStream.close();
        }
}