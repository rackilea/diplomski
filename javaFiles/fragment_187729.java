public class PropertiesConfigurationExtended extends PropertiesConfiguration{

    private static final char[] SEPARATORS = new char[] {'=', ':'};
    private static final char[] WHITE_SPACE = new char[]{' ', '\t', '\f'};
    private static final String ESCAPE = "\\";

    public static class PropertiesWriter extends PropertiesConfiguration.PropertiesWriter{
        private char delimiter;
        /**
         * Constructor.
         */
        public PropertiesWriter(Writer writer, char delimiter)
        {
            super(writer,delimiter);
            this.delimiter = delimiter;
        }
        public void writeProperty(String key, Object value,
                boolean forceSingleLine) throws IOException
        {
            String v;    
            if (value instanceof List)
            {
                List values = (List) value;
                if (forceSingleLine)
                {
                    v = makeSingleLineValue(values);
                }
                else
                {
                    writeProperty(key, values);
                    return;
                }
            }
            else
            {
                v = escapeValue(value);
            }

            write(escapeKey(key));
            write(" = ");
            write(v);

            writeln(null);
        }
        /**
         * Rewrite the escapeValue method to avoid escaping of the given property value.
         *
         * @param value the property value
         * @return the same property value
         */
        private String escapeValue(Object value)
        {
            return String.valueOf(value);
        }
    }
}