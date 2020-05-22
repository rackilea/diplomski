File file = new File("sample.txt");
FileWriter fw = null;
try {
    fw = new FileWriter(file, true);
    fw.append('d');
    fw.write(100);
} catch(IOException) {
    // Ideally do something to indicate the failure to the caller
    // - do you need to catch this at all?
    e.printStackTrace();
} finally {
    // From Guava
    Closeables.closeQuietly(fw);
}