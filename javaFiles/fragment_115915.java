public void writeToFile(String filePath) {
    try (PrintWriter outFile = new PrintWriter(filePath)) {
        generateReport(outFile);
    } catch (FileNotFoundException e) {
        System.out.println("File not found");
        e.printStackTrace();
    }
}

private void generateReport(PrintWriter outFile) {
    outFile.print("Hello world");
}