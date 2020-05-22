void split(File inputFile, File outputFile) {
    Inputstream is = new BufferedInputStream(new FileInputStream(inputFile));
    OutputStream os = new BufferedOutputStream(new FileOutputStream(outputFile));
    for (;;) {
        Document doc = readDocument(is);
        if (doc == null) break;
        write(buildXml(doc), os);
    }
    os.close();
    is.close();
}