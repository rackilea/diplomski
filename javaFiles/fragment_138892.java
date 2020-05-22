import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Play  {


    public static void parse(String classFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(classFile));
        try {
            String line = br.readLine();
            // a comment with a while "while" and 'while'
            int total = 0;
            while (line != null) { // just a dumb comment in the same line as the while
                if (line.indexOf("//") > -1) {
                    line = line.substring(0, line.indexOf("//"));
                }
                if (line.indexOf("/*") > -1) { // comment-starts
                    line = line.substring(0, line.indexOf("/*"));
                    total += checkIfValidWhileInLine(line);
                    line = br.readLine();
                    // ignore comments like /* ... */
                    while (line.indexOf("*/") < 0) {
                        line = br.readLine();
                    }
                    line = line.substring(0, line.indexOf("*/"));
                }
                total += checkIfValidWhileInLine(line);
                line = br.readLine();
            }
            System.out.println(total);
        } finally {
            br.close();
        }

    }

    private static int checkIfValidWhileInLine(String line) {
        if (line.matches("^.*?\\bwhile\\b.*$")) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        parse("/Users/alfasi/IdeaProjects/HelloWorld/src/Play.java");
    }
}