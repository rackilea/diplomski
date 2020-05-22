public class Main {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("javaw", "-version")
                .inheritIO();
        Process p = pb.start();
        int returnValue = p.waitFor();
        System.out.println(returnValue);
    }
}