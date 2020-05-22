static class InputStreamReaderRunnable implements Runnable {
    private StringBuilder sb;
    private InputStream is;

    public InputStreamReaderRunnable(InputStream is) {
        this.is = is;
        this.sb = new StringBuilder();
    }

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}

public static void main(String[] args) {
    ProcessBuilder pb = new ProcessBuilder("curl",
            "http://genome.ucsc.edu/cgi-bin/das/mm9/dna?segment=chr1:3206424,3206499");
    try {
        Process p = pb.start();
        InputStreamReaderRunnable isrr = new InputStreamReaderRunnable(
                p.getInputStream());
        Thread t = new Thread(isrr);
        t.start();
        p.waitFor();
        t.join();
        String out = isrr.toString();
        System.out.println(out);
    } catch (Exception e) {
        e.printStackTrace();
    }
}