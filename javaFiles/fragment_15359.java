// DON'T DO THIS
try (BufferedWriter bw = new BufferedWriter(
        new OutputStreamWriter(
        new GZIPOutputStream(
        new FileOutputStream(createdFile))))) {
    // ...
}