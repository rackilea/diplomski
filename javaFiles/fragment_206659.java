private void writeFile (XMLStreamWriter sw, InputStream is){
    //is - FileInputStream
    Reader reader = new InputStreamReader(new Base64InputStream(is, true, -1, null));
    char[] buf = new char[4096];
    int n;
    while( (n = reader.read(buf)) >= 0 ) {
        sw.writeCharacters(buf, 0, n);
    }
}