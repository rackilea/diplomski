public String fileToBuffer(InputStream is, StringBuffer strBuffer) throws IOException {
    StringBuilder sb = new StringBuilder(strBuffer);
    try (BufferedReader rdr = new BufferedReader(new InputStreamReader(is))) { 
        for (int c; (c = rdr.read()) != -1;) {
            sb.append((char) c);

        }
    }
    return sb.toString();
}