import java.io.*;
import java.util.*;
class Dmitri {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter("out.txt");
        while(in.hasNextLine()) {
            String line = in.nextLine();
            out.println(line);
            out.flush(); // not necessary every time, but simple to do so
            if(line.equalsIgnoreCase("QUIT")) break;
        }
        out.close();
    }
}