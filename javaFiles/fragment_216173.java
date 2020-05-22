import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SimpleFileReader {
    private static final String DELEMETER = ":";
    private String filename = null;

    public SimpleFileReader() {
        super();
    }

    public SimpleFileReader(String filename) {
        super();
        setFilename(filename);
    }   

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<List<String>> getRowSet() throws IOException {
        List<List<String>> rows = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(row -> rows.add(Arrays.asList(row.split(DELEMETER))));
        }

        return rows;
    }
}