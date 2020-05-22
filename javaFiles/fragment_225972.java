private final ConcurrentHashMap<String, List<String>> matchLocations = new ConcurrentHashMap<>();
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
            Reader reader = new Reader(listOfStrings, fileEntry);
            pool.submit(reader);
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
        try (FileInputStream fileInputStream = new FileInputStream(file);
             FileChannel channel = fileInputStream.getChannel()) {
            StringBuilder sb = new StringBuilder();
            ByteBuffer buffer = ByteBuffer.allocate(512);
            int read;
            while (true) {
                read = channel.read(buffer);
                if (read == -1) {
                    break;
                }
                buffer.flip();
                sb.append(new String(buffer.array()).toLowerCase());
                buffer.clear();
            }
            listOfStrings.stream()
                    .map(String::toLowerCase)
                    .forEach(s -> {
                        if (sb.indexOf(s) > 0) {
                            List<String> current = matchLocations.get(s);
                            if (current == null) {
                                current = new ArrayList<>();
                                matchLocations.put(s, current);
                            }
                            current.add(file.getAbsolutePath());
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}