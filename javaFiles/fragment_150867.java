import java.io.File;
import java.io.IOException;

public class TestExec {

    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("d:/Clipboard1.png");
        ProcessBuilder builder = new ProcessBuilder("RUNDLL32.EXE", "SHELL32.DLL,OpenAs_RunDLL", file.getAbsolutePath());
        builder.redirectErrorStream();
        builder.redirectOutput();
        Process process = builder.start();
        process.waitFor();
    }

}