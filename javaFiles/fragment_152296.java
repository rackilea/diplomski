interface Segment {}

class SEG1 implements Segment
{
    void setField1(final String field){};
    void setField2(final String field){};
    void setField3(final String field){};
}

enum Parser {
    SEGMENT1("SEG1") {
        @Override
        protected Segment parse(final String[] fields)
        {
            final SEG1 segment = new SEG1();
            segment.setField1(fields[0]);
            segment.setField1(fields[1]);
            segment.setField1(fields[2]);
            return segment;
        }
    },        
    ...
    ;

    private final String name;

    private Parser(final String name)
    {
        this.name = name;
    }

    protected abstract Segment parse(String[] fields);

    public static Segment parse(final String segment)
    {
        final int firstSeparator = segment.indexOf('|');

        final String name = segment.substring(0, firstSeparator);
        final String[] fields = segment.substring(firstSeparator + 1).split("\\|");

        for (final Parser parser : values())
            if (parser.name.equals(name))
                return parser.parse(fields);

        return null;
    }
}