import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

public class SourceCodeProgram {

    public static void main(String[] args) throws Exception {
        File source = new File("C:\\test.txt");
        SourceCodeScanner scanner = new SourceCodeScanner(source);
        for (Code code : scanner.readAll()) {
            System.out.println(code);
            System.out.println("-----------");
        }
    }
}

class SourceCodeScanner {

    private File source;

    private Pattern startCodePattern = Pattern.compile(
            "^(\\s)*(program|function|process)", Pattern.CASE_INSENSITIVE);

    public SourceCodeScanner(File source) {
        this.source = source;
    }

    public Collection<Code> readAll() throws Exception {
        List<String> lines = readFileLineByLine();
        List<Code> codes = new ArrayList<Code>();
        StringBuilder builder = new StringBuilder(512);

        for (String line : lines) {
            if (containsSourceCodeHeader(line)) {
                int length = builder.length();
                if (length != 0) {
                    codes.add(new Code(builder.toString().trim()));
                    builder.delete(0, length);
                }
            }
            addNextLineOfSourceCode(builder, line);
        }
        String lastCode = builder.toString();
        if (containsSourceCodeHeader(lastCode)) {
            codes.add(new Code(builder.toString().trim()));
        }
        return codes;
    }

    private boolean containsSourceCodeHeader(String line) {
        return startCodePattern.matcher(line).find();
    }

    private void addNextLineOfSourceCode(StringBuilder builder, String line) {
        builder.append(line);
        builder.append(IOUtils.LINE_SEPARATOR);
    }

    private List<String> readFileLineByLine() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(source);
        return IOUtils.readLines(new BufferedInputStream(fileInputStream));
    }
}

class Code {
    private String value;

    public Code(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}