import example.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

    public class ParserTest {

        @Test
        public void shouldReturnParsedTextFromInputFileStream() throws Exception {
            String text = "row1\nrow2\nrow3";
            InputStream inputFileStream = new ByteArrayInputStream(text.getBytes());
            Parser parser = new Parser();
            List<String> result = parser.getListOfAirportsFromCsvAsAStrings(inputFileStream);
            List<String> expected = Arrays.asList("row1", "row2", "row3");
            Assert.assertEquals(expected, result);
        }
    }