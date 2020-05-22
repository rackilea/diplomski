package java.text;

public interface CharacterIterator extends Cloneable
{
    /**
     * Constant that is returned when the iterator has reached either the end
     * or the beginning of the text. The value is '\\uFFFF', the "not a
     * character" value which should not occur in any valid Unicode string.
     */
    public static final char DONE = '\uFFFF';