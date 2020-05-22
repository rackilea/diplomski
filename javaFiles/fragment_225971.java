private final ConcurrentHashMap<String, String> matchLocations = new ConcurrentHashMap<>();
private final ForkJoinPool pool = new ForkJoinPool();
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
            pool.submit(new Reader(listOfStrings, fileEntry));
        }
    });
}

class Reader implements Runnable {

    final List<String> listOfStrings;
    final File file;

    Reader(List<String> listOfStrings, File file) {
        this.listOfStrings = listOfStrings;
        this.file = file;
    }

    @Override
    public void run() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8);
            StringBuilder sb = new StringBuilder();
            lines.forEach(s -> sb.append(s.toLowerCase()).append("\n"));
            listOfStrings.forEach(s -> {
                if (sb.indexOf(s.toLowerCase()) > 0) {
                    matchLocations.put(s, file.getPath());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}