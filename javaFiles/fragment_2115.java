private String readYamlFile(String) throws IOException {
    try{
       ...
    } catch (IOException e) {
        throw new IOException("Not able to load file", e);
    }
}