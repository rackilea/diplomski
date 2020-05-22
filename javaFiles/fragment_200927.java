package org.supercsv.example;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class ReadWithCsvBeanReader {

    private static final String CSV = 
            "firstname, lastname, dog_name, fav_hat, fav_color\n"
            + "bill,smith,fido,porkpie,blue\n"
            + "james,smith,rover,bowler,purple";

    private static final String CSV2 = 
            "firstname, lastname, car_type, floor_number\n"
            + "tom, collins, ford, 14\n" + "jim, jones, toyota, 120";

    // attributes start at element 2 of the header array
    private static final int ATT_START_INDEX = 2;

    // custom preferences required because CSV contains 
    spaces that aren't part of the data
    private static final CsvPreference PREFS = 
        new CsvPreference.Builder(
            CsvPreference.STANDARD_PREFERENCE)
            .surroundingSpacesNeedQuotes(true).build();

    public static void main(String[] args) throws IOException {
        System.out.println("CsvBeanReader with first CSV input:");
        readWithCsvBeanReader(new StringReader(CSV));
        System.out.println("CsvBeanReader with second CSV input:");
        readWithCsvBeanReader(new StringReader(CSV2));
    }

    private static void readWithCsvBeanReader(final Reader reader)
            throws IOException {
        ICsvBeanReader beanReader = null;
        try {
            beanReader = new CsvBeanReader(reader, PREFS);

            final String[] header = beanReader.getHeader(true);

            // set up the field mapping and processors dynamically
            final String[] fieldMapping = new String[header.length];
            final CellProcessor[] processors = 
                    new CellProcessor[header.length];
            for (int i = 0; i < header.length; i++) {
                if (i < ATT_START_INDEX) {
                    // normal mappings
                    fieldMapping[i] = header[i];
                    processors[i] = new NotNull();
                } else {
                    // attribute mappings
                    fieldMapping[i] = "addAttribute";
                    processors[i] = 
                            new Optional(new ParsePersonAttribute(header));
                }
            }

            Person person;
            while ((person = beanReader.read(Person.class, fieldMapping,
                    processors)) != null) {
                System.out.println(String.format(
                        "lineNo=%s, rowNo=%s, person=%s",
                        beanReader.getLineNumber(), beanReader.getRowNumber(),
                        person));
            }

        } finally {
            if (beanReader != null) {
                beanReader.close();
            }
        }
    }

}