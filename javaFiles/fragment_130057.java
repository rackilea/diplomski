package org.supercsv.io;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.supercsv.prefs.CsvPreference;

public class SkipBlankLinesTokenizer extends Tokenizer {

    public SkipBlankLinesTokenizer(Reader reader, CsvPreference preferences) {
        super(reader, preferences);
    }

    @Override
    public boolean readColumns(List<String> columns) throws IOException {

        boolean moreInput = super.readColumns(columns);

        // keep reading lines if they're blank
        while (moreInput && (columns.size() == 0 || 
                             columns.size() == 1 && 
                             columns.get(0).trim().isEmpty())){
            moreInput = super.readColumns(columns);
        }

        return moreInput;
    }

}