ProcessBuilder pb = new ProcessBuilder("curl",
        "http://genome.ucsc.edu/cgi-bin/das/mm9/dna?"
        + "segment=chr1:3206424,3206499");
pb.inheritIO();
try {
    Process p = pb.start();
    p.waitFor();
} catch (Exception e) {
    e.printStackTrace();
}