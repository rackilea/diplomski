public final class LogEntry {
    private final Pattern pattern = Pattern.compile("Rover file: (.*)" +
                                                   "|(\\d+)% total coverage" +
                                                   "|(\\d+)% coverage by (.*)");
    private String roverFile;
    private Integer totalCoverage;
    private Map<String, Integer> fileCoverage = new LinkedHashMap<>();

    public void process(BufferedReader in) throws IOException {
        for (String line; (line = in.readLine()) != null; ) {
            Matcher m = this.pattern.matcher(line);
            if (! m.matches())
                continue;
            if (m.start(1) != -1) {
                print();
                clear();
                this.roverFile = m.group(1);
            } else if (m.start(2) != -1) {
                this.totalCoverage = Integer.valueOf(m.group(2));
            } else if (m.start(3) != -1) {
                this.fileCoverage.put(m.group(4), Integer.valueOf(m.group(3)));
            }
        }
        print();
    }

    private void clear() {
        this.roverFile = null;
        this.totalCoverage = null;
        this.fileCoverage.clear();
    }

    private void print() {
        if (this.roverFile == null)
            return;
        if (this.fileCoverage.isEmpty()) {
            System.out.println(this.roverFile + "," + this.totalCoverage);
        } else {
            for (Entry<String, Integer> entry : this.fileCoverage.entrySet()) {
                System.out.println(this.roverFile + "," + this.totalCoverage + "," + entry.getValue() + "," + entry.getKey());
            }
        }
    }
}