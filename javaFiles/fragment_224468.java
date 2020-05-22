static final Path counterFile = FileSystems.getDefault().getPath("useCount.txt");

public Founder() throws IOException {
    initComponents();

    // read use count from file
    int useCount;
    if (Files.exists(counterFile)) {
        List<String> line = Files.readAllLines(counterFile);
        if (line.size() == 1) { // one line in file as expected
            useCount = Integer.parseInt(line.get(0));
        } else { // not the right file, ignore lines from it
            useCount = 0;
        }
    } else { // program has never run before
        useCount = 0;
    }
    useCount++;

    jLabel1.setText(String.valueOf(useCount));

    // write new use count back to file
    Files.write(counterFile, Arrays.asList(String.valueOf(useCount)));
}