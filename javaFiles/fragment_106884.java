public class Test {
    public static void main(String[] args) throws Exception {

        String[] cmd = { "C:\\E.M. TVCC\\TVCC.exe", "-f E:\\TestVideo\\01.avi", "-o E:\\OutputFiles\\target.3gp" };
        Process p = Runtime.getRuntime().exec(cmd);
        p.waitFor();
    }
}