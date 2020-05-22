import java.io.IOException;

public class TestClass {
    public static void main(String[] args) throws IOException {
        Runtime rt = Runtime.getRuntime();  
        Process pr = rt.exec("cmd.exe /c mspaint.exe");
    }
}