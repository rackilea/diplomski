public void writeInFile(String path, List<String> content) {
    File file = new File(path);
    File parent = file.getParentFile();
    if (parent != null && !parent.exists())
        parent.mkdirs();

    try (PrintWriter writer = new PrintWriter(path, "ASCII")) {
        for (String contentItem : content) {
            writer.println(contentItem);
        }
        writer.close();
    } catch (IOException e1) {
        //DO STUFF
    }
}