File selectedFile = chooser.getSelectedFile();
try (InputStream stream = new FileInputStream(selectedFile);
    Reader reader = new InputStreamReader(stream, "UTF-8"); // or whatever
    BufferedReader in = new BufferedReader(reader)) {
    String line = in.readLine();
    while (line != null) {
        String[] fields = line.split("\\s");
        doSomethingWith(fields);
        line = in.readLine();
    }
}