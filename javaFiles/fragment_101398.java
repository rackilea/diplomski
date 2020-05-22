import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Foo {
    public static void main(String[] args) throws Exception {
        if (args.length != 0)
            System.exit(Integer.parseInt(args[0]));
        ProcessBuilder builder = new ProcessBuilder(Arrays.asList("java", "Foo", "42"));
        Process process = builder.start();
        System.out.println(process .waitFor());     
    }
}