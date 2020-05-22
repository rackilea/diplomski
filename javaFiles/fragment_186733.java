public ArrayList<String> getFileLines(String filePath) throws IOException {
    ArrayList<String> content = new ArrayList<>();
    String line = "";
    BufferedReader in = new BufferedReader(new FileReader(filePath));
    while((line=in.readLine()) != null) {
        content.add(line);
    }
    return content;
}