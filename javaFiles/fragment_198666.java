public class CmdTest {
public static void main(String[] args) throws Exception {
    ProcessBuilder builder = new ProcessBuilder(
        "cmd.exe",
        "/c",
        "cd \"C:\\Users\\ray\\Documents\\Project\" && runhaskell ",
        "test.hs");
    builder.redirectErrorStream(true);
    Process p = builder.start();
    BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
    String line;
    while (true) {
        line = r.readLine();
        if (line == null) { break; }
        System.out.println(line);
    }
}
}