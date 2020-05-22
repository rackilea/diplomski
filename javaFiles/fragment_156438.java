public static void main(String[] args) {
    // define the directory that contains the text files
    String dir = "U:\\workspace\\git\\ZZ--Temp\\TextFiles";
    Path dirPath = Paths.get(dir);
    // predefine some lines to be appended to every file
    List<String> linesToBeAppended = new ArrayList<>();
    linesToBeAppended.add("Hello new line in the file!");

    try {
        // go through all files in the directory (tested with .txt files only)
        Files.list(dirPath)
            // filter only files
            .filter(Files::isRegularFile)
            .forEach(filePath -> {
                try {
                    // append the predefined text to the file
                    Files.write(filePath, linesToBeAppended, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    System.err.println("Could not append text to file " 
                            + filePath.toAbsolutePath().toString());
                    e.printStackTrace();
                }
            });
    } catch (IOException e) {
        System.err.println("Could not list files in " 
                + dirPath.toAbsolutePath().toString());
        e.printStackTrace();
    }
}