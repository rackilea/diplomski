public void writeArrayInFile(String filePath, ArrayList<String> content) throws IOException {
    BufferedWriter out = new BufferedWriter( new FileWriter(filePath) );
    for (String l : content) {
        out.write(l + "\n");
    }
    out.close();
}