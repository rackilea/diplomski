import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class ReversedLineBufferedReader extends BufferedReader {

    public ReversedLineBufferedReader(Reader in) {
        super(in);
    }

    @Override
    public String readLine() throws IOException {
        String line = super.readLine();

        if (line == null) {
            return null;
        }

        StringBuilder reversedLine = new StringBuilder();
        if (line.length() > 0) {
            String[] splitString = line.split("\\b");
            for (int i = splitString.length; i > 0; i--) {
                reversedLine.append(splitString[i - 1]).append(" ");
            }
        }
        return reversedLine.toString();
    }
}