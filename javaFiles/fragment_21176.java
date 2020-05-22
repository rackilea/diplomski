Reader reader = new BufferedReader(new FileReader(file));
try {
    // do stuff
} finally {
    try {
        reader.close();
    } catch (IOException ex) {
        // ...
    }
}