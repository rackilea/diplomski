import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Collections;

public class Test {
    public static void main(String[] args) throws Exception {

        Path binary = Paths.get("mybinary");
        Files.copy(Test.class.getResourceAsStream("mybinary"), binary);

        System.out.println("Launching external program...");

        // Needed for Linux at least
        Files.setPosixFilePermissions(binary,
                Collections.singleton(PosixFilePermission.OWNER_EXECUTE));

        Process p = new ProcessBuilder("./mybinary").inheritIO().start();
        p.waitFor();
        System.out.println("External program finished.");
    }
}