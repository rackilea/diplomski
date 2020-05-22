import java.io.*;
class Test {
public static void main(String args[]) {
    try {
        Process p = Runtime.getRuntime().exec(
                "python Test.py ");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                p.getInputStream()));
        System.out.println(in.readLine());
    } catch (Exception e) {
    }
}