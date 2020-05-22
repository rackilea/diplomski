public static void main(String[] args) {
    // define the directory that contains the text files
    String dir = "U:\\workspace\\git\\ZZ--Temp\\TextFiles";
    Path dirPath = Paths.get(dir);

    try {
        // go through all files in the directory (tested with .txt files only)
        Files.list(dirPath)
            // filter only files
            .filter(Files::isRegularFile)
            .forEach(filePath -> {
                // predefine some lines to be appended to every file
                List<String> linesToBeAppended = new ArrayList<>();
                // add the first line as predefined first line
                linesToBeAppended.add("Hello another line in the file!");

                try {
                    // then read the file and add its lines to the list with
                    // that already contains the new first line
                    linesToBeAppended.addAll(Files.readAllLines(filePath));
                    // append the extended text to the file (again),
                    // but this time overwrite the content
                    Files.write(filePath, linesToBeAppended,
                                StandardOpenOption.TRUNCATE_EXISTING);
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