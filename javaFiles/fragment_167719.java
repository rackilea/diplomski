while((line=bufReader.readLine()) != null){
    StringTokenizer st = new StringTokenizer(line);
    readPrevisione(st,bufReader);
}

private void readPrevisione(StringTokenizer st, BufferedReader bufReader) throws IOException, BadFileFormatException{
String nomeSettore = st.nextToken().trim();
...}