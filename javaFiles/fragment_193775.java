public void doSomethingWithFile(String fileName) throws IOException {
    if (/* file is not accessible */) {
        throw new IOException("File " + fileName + " is not accessible!");
    }
    ...
}
public void caller() {
    try {
        doSomethingWithFile("/home/honza/file.txt");
    }
    catch (IOException e) {
        // handle the fact that the file is not accessible
        return;
    }
    ...
}