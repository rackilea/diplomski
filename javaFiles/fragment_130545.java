import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Translator {

    private static final String PROPERTIES_FILE_NAME = "translations.properties";
    private final Properties translations = new Properties();

    public Translator() {
        // Below is the try-with-resources syntax, available since 1.7
        // See: http://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        try (InputStream input = Translator.class.getResourceAsStream(PROPERTIES_FILE_NAME)) {
            System.out.println(input);
            translations.load(input);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(final String[] args) {
        final Translator translator = new Translator();
        System.out.println(translator.translate("abcABC123"));
    }

    private String translate(final String input) {
        final StringBuilder sb = new StringBuilder();
        for (final char c : input.toCharArray()) {
            sb.append(translate(c));
        }
        return sb.toString();
    }

    private String translate(final char c) {
        String translation = translations.getProperty(String.valueOf(c));
        if (translation == null) {
            translation = Character.toString(c);
        }
        return translation;
    }
}