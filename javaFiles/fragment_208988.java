import org.codehaus.jackson.SerializableString;
import org.codehaus.jackson.io.CharacterEscapes;

// First, definition of what to escape
public class HTMLCharacterEscapes extends CharacterEscapes
{
    private final int[] asciiEscapes;

    public HTMLCharacterEscapes()
    {
        // start with set of characters known to require escaping (double-quote, backslash etc)
        int[] esc = CharacterEscapes.standardAsciiEscapesForJSON();
        // and force escaping of a few others:
        esc['<'] = CharacterEscapes.ESCAPE_STANDARD;
        esc['>'] = CharacterEscapes.ESCAPE_STANDARD;
        esc['&'] = CharacterEscapes.ESCAPE_STANDARD;
        esc['\''] = CharacterEscapes.ESCAPE_STANDARD;
        asciiEscapes = esc;
    }
    // this method gets called for character codes 0 - 127
    @Override public int[] getEscapeCodesForAscii() {
        return asciiEscapes;
    }
    // and this for others; we don't need anything special here
    @Override public SerializableString getEscapeSequence(int ch) {
        // no further escaping (beyond ASCII chars) needed:
        return null;
    }
}

// and then an example of how to apply it
public ObjectMapper getEscapingMapper() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.getJsonFactory().setCharacterEscapes(new HTMLCharacterEscapes());
    return mapper;
}

// so we could do:
public byte[] serializeWithEscapes(Object ob) throws IOException
{
    return getEscapingMapper().writeValueAsBytes(ob);
}