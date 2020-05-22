public class KeepTopTenFiles {

    public static void main(String[] args) throws IOException {
        ArrayList<File> files = new ArrayList<>();
        createDummyFiles(files);
        Collections.shuffle(files);

        files.stream()
                .filter((File p) -> p.getName().matches("foobar_.*"))
                .sorted(getReverseLastModifiedComparator())
                .skip(10)
                // to delete the file but keep the most recent ten
                // .forEach(x -> ((File) x).delete());
                // or display the filenames which would be deleted
                .forEach((x) -> System.out.printf("would be deleted: %s%n", x));
    }

    private static Comparator<File> getReverseLastModifiedComparator() {
        return (File o1, File o2) -> {
            if (o1.lastModified() < o2.lastModified()) {
                return 1;
            }
            if (o1.lastModified() > o2.lastModified()) {
                return -1;
            }
            return 0;
        };
    }

    private static void createDummyFiles(ArrayList<File> files) throws IOException {
        long timestamp = System.currentTimeMillis();
        int filesToCreate = 30;
        for (int i = 0; i < filesToCreate; i++) {
            long lastModified = timestamp + 5 * i;
            String fileName = String.format("foobar_%02d", i);
            File file = new File(fileName);
            file.createNewFile();
            file.setLastModified(lastModified);
            files.add(file);
        }
    }
}