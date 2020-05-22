package org.supercsv.example;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.util.CsvContext;

/**
 * Creates a PersonAttribute using the corresponding header as the key.
 */
public class ParsePersonAttribute extends CellProcessorAdaptor {

    private final String[] header;

    public ParsePersonAttribute(final String[] header) {
        this.header = header;
    }

    public Object execute(Object value, CsvContext context) {

        if( value == null ) {
            return null;
        }

        PersonAttribute attribute = new PersonAttribute();
        // columns start at 1
        attribute.setKey(header[context.getColumnNumber() - 1]);
        attribute.setValue((String) value);
        return attribute;
    }

}