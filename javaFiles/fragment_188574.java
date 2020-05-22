import java.io.*;

class CompileData {
    public static void main(String args[]) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("one.txt");