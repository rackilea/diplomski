class Main {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("./to_stderr.sh");
        pb.start();
    }
}