String readFromRSClobStream(Reader reader, int clobSizeHint, int bufferSize) 
       throws IOException {       
    StringBuilder sb = new StringBuilder(clobSizeHint);
    char[] buffer = new char[buffersize];
    int count = 0;
    while ((count = reader.read(buffer)) != -1) {
        sb.append(buffer, 0, count);
    }
    return sb.toString;
}