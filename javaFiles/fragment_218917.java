FileReader reader = null;
try {
    reader = new FileReader("myfile.txt");
    textArea.read(reader, null);
} finally {
    if (reader != null) {
        reader.close();
    }
}