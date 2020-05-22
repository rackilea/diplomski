String folderPath = "/your/path";
String contentRegexp = "2018(.+)";
String contentReplacement = "XXXX";
String filenameRegexp = "-2018(.+)\\d";
String filenameReplacement = "";

// 1 is a maximum depth of traversal; 
// you can use it if you have any subdirectories wich you want to process too
try (Stream<Path> paths = Files.walk(Paths.get(folderPath), 1)) {
    // filtering only files
    paths.filter(file -> Files.isRegularFile(file))
         .forEach(file -> {
                try {
                    //reading all lines and replacing content in each line
                    List<String> lines = Files.readAllLines(file)
                        .stream()
                        .map(s -> s.replaceAll(contentRegexp, contentReplacement))
                        .collect(Collectors.toList());
                    //writing lines back
                    Files.write(file, lines, StandardOpenOption.WRITE,
                                             StandardOpenOption.TRUNCATE_EXISTING);
                    //renaming file
                    Files.move(file, file.resolveSibling(file.getFileName()
                                   .toString()
                                   .replaceAll(filenameRegexp, filenameReplacement)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
          });
}