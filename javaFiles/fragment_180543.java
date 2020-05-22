import java.io.IOException;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(Arrays.asList("sort", "--field-separator=,", "--key=2", "/tmp/sample.csv", "-o",
                "/tmp/sample_temp.csv"));
        Process p = pb.start();
        int returnCode = p.waitFor();
        System.out.println(returnCode);
    }

}