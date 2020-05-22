import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.ReaderInputStream;

import com.github.rwitzel.streamflyer.core.ModifyingReader;
import com.github.rwitzel.streamflyer.regex.RegexModifier;

public class InputStreamModifiedWithRegex {
    private static final Charset ENCODE_CHARSET = Charset.forName("UTF-8");

    public static void main(String[] args) throws IOException {
        InputStream input = IOUtils.toInputStream("AB CD EF");
        InputStream updatedInput = applyRegex(input, "[A-C]", "Z");
        System.out.println(IOUtils.toString(updatedInput, ENCODE_CHARSET));
    }

    private static InputStream applyRegex(InputStream inputStream, String pattern, String changeString)
            throws UnsupportedEncodingException {
        Reader originalReader = new InputStreamReader(inputStream, ENCODE_CHARSET);
        Reader modifyingReader = new ModifyingReader(originalReader, new RegexModifier(pattern, 0, changeString));
        inputStream = new ReaderInputStream(modifyingReader, ENCODE_CHARSET);

        return inputStream;
    }
}