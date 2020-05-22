public class Main {
public static void main(String[] args) {
    try {
        ProcessBuilder pb = new ProcessBuilder("C:\\Windows\\System32\\calc.exe");
        Process p1 = pb.start();
        p1.waitFor();
        System.out.println(p1.exitValue());
    } catch (Exception e) {
        System.out.print(e);
    }
}

}