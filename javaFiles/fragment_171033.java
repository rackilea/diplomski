public void loadFiles(String... fileNames) throws FileNotFoundException, IOException {
    BufferedReader[] buf_file = new BufferedReader[fileNames.length];
    for (int i = 0; i < fileNames.length; i++) {
        buf_file[i] = new BufferedReader(new FileReader(new File(fileNames[i])));
    }
}