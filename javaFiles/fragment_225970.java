private final Map<String, String> matchLocations = new HashMap<>();
private int currentCount = 0;

public void scanMyDirectory(final File myDirectory, final List<String> listOfStrings) {
    File[] files = myDirectory.listFiles();
    if (files == null) {
        return;
    }
    Stream.of(files).forEach(fileEntry -> {
        if (fileEntry.isDirectory()) {
            scanMyDirectory(fileEntry, listOfStrings);
        } else {
            System.out.println("Entering file: " + currentCount++);
            try {
                List<String> lines = Files.readAllLines(Paths.get(fileEntry.getAbsolutePath()), StandardCharsets.UTF_8);
                StringBuilder sb = new StringBuilder();
                lines.forEach(s -> sb.append(s.toLowerCase()).append("\n"));
                listOfStrings.forEach(s -> {
                    if (sb.indexOf(s.toLowerCase()) > 0) {
                        matchLocations.put(s, fileEntry.getPath());
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });
}