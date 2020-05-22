package test;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSPParser {
    public static void main(String[] args) throws Exception {
        Pattern pattern = Pattern
            .compile("([A-Za-z]+\\w?\\s*=\\s*(\")<%=\\s*[^%>]*\"+[^>]*\\s*%>(\")\\s*)");

        // Pass the input JSP in the first argument
        FileReader fr = new FileReader(args[0]);
        LineNumberReader lnr = new LineNumberReader(fr);
        String fileName = args[0];
        int n = fileName.lastIndexOf("/");

        // You must have a "was" subdirectory from the source location
        fileName = fileName.substring(0, n + 1) + "was/" + fileName.substring(n + 1);

        FileOutputStream fos = new FileOutputStream(fileName);
        String line = null;
        while ((line = lnr.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                n = matcher.groupCount();
                for (int i = 2; i <= n; i++) {
                    line = line.substring(0, matcher.start(i)) + "'"
                            + line.substring(matcher.end(i));
                }
            }
            fos.write(line.getBytes());
            fos.write("\n".getBytes());
        }
        fos.flush();
        fos.close();
        lnr.close();
    }
}