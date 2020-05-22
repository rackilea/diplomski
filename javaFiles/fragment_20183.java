package thaicharacters;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class ThaiCharacters {

public static void main(String[] args) throws UnsupportedEncodingException {

    String engParam = "Beautiful";
    String thaiParam = "สวย";

    // Write the output to a UTF-8 PrintStream:
    PrintStream ps = new PrintStream(System.out, true, StandardCharsets.UTF_8.name());
    ps.println("UTF-8: " + engParam + ":::" + thaiParam);
}
}