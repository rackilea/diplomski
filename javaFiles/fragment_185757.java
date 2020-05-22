package misctests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


public class SplitToWords {

    String someWords = "Lorem ipsum\r\n(dolor@sit)amet,\nconsetetur!\rsadipscing'elitr;sed~diam";
    String delimsRegEx = "[\\s;,\\(\\)!'@~]+";
    String delimsPlain = ";,()!'@~"; // without whitespaces

    String[] expectedWords = {
        "Lorem",
        "ipsum",
        "dolor",
        "sit",
        "amet",
        "consetetur",
        "sadipscing",
        "elitr",
        "sed",
        "diam"
    };

    private static final class StringReader {
        String input = null;
        int pos = 0;
        int len = 0;
        StringReader(String input) {
            this.input = input == null ? "" : input;
            len = this.input.length();
        }

        public boolean hasMoreChars() {
            return pos < len;
        }

        public int read() {
            return hasMoreChars() ? ((int) input.charAt(pos++)) : 0;
        }
    }

    @Test
    public void splitToWords_1() {
        String[] actual = someWords.split(delimsRegEx);
        assertEqualsWords(expectedWords, actual);
    }

    @Test
    public void splitToWords_2() {
        StringReader sr = new StringReader(someWords);
        List<String> words = new ArrayList<String>();
        StringBuilder sb = null;
        int c = 0;
        while(sr.hasMoreChars()) {
            c = sr.read();
            while(sr.hasMoreChars() && isDelimiter(c)) {
                c = sr.read();
            }
            sb = new StringBuilder();
            while(sr.hasMoreChars() && ! isDelimiter(c)) {
                sb.append((char)c);
                c = sr.read();
            }
            if(! isDelimiter(c)) {
                sb.append((char)c);
            }
            words.add(sb.toString());
        }

        String[] actual = new String[words.size()];
        words.toArray(actual);

        assertEqualsWords(expectedWords, actual);
    }

    private boolean isDelimiter(int c) {
        return (Character.isWhitespace(c) ||
            delimsPlain.contains(new String(""+(char)c))); // this part is subject for optimization
    }

    private void assertEqualsWords(String[] expected, String[] actual) {
        assertNotNull(expected);
        assertNotNull(actual);
        assertEquals(expected.length, actual.length);
        for(int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}