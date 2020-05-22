import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SimpleFileReaderTest {
    public SimpleFileReaderTest() {
        super();
    }

    @Test
    public void testFileReader() {

        try {
            SimpleFileReader reader = new SimpleFileReader("c:/temp/sample-input.txt");
            List<List<String>> rows = reader.getRowSet();

            int expectedValue = 3; // number of actual lines in the sample file
            int actualValue = rows.size(); // number of rows in the list

            if (actualValue != expectedValue) {
                fail(String.format("Expected value for the row count is %d, whereas obtained value is %d", expectedValue, actualValue));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}