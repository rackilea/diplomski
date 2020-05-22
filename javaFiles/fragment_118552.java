public class DirectoryStreamReader {

    public Map<String, String> read(Path directory) {

        Map<String, String> fileContentsByName = new HashMap<String, String>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {
            for (Path path : directoryStream) {
                if (Files.isRegularFile(path)) {
                    fileContentsByName.put(path.getFileName().toString(), new String(Files.readAllBytes(path)));
                }
            }
        } catch (IOException e) {
        }

        return fileContentsByName;
    }
}