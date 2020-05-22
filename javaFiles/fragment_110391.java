import java.io.*;

public class App{
    public static void main(String[] args) throws Exception{
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write("i am writing to stdin");
        out.flush();
    }
}