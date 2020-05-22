package example;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.supercsv.io.CsvMapReader;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.io.ICsvMapWriter;
import org.supercsv.prefs.CsvPreference;

public class CombiningPersonAndAddress {

    private static final String PERSON_CSV = "id,firstName,lastName\n"
            + "1,philip,fry\n2,amy,wong\n3,hubert,farnsworth";

    private static final String ADDRESS_CSV = "personId,address,country\n"
            + "1,address 1,USA\n2,address 2,UK\n3,address 3,AUS";

    private static final String[] COMBINED_HEADER = new String[] { "id",
            "firstName", "lastName", "address", "country" };

    public static void main(String[] args) throws Exception {

        ICsvMapReader personReader = null;
        ICsvMapReader addressReader = null;
        ICsvMapWriter combinedWriter = null;
        final StringWriter output = new StringWriter();

        try {
            // set up the readers/writer
            personReader = new CsvMapReader(new StringReader(PERSON_CSV),
                    CsvPreference.STANDARD_PREFERENCE);
            addressReader = new CsvMapReader(new StringReader(ADDRESS_CSV),
                    CsvPreference.STANDARD_PREFERENCE);
            combinedWriter = new CsvMapWriter(output,
                    CsvPreference.STANDARD_PREFERENCE);

            // map of personId -> address (inner map is address details)
            final Map<String, Map<String, String>> addresses = 
                    new HashMap<String, Map<String, String>>();

            // read in all of the addresses
            Map<String, String> address;
            final String[] addressHeader = addressReader.getCSVHeader(true);
            while ((address = addressReader.read(addressHeader)) != null) {
                final String personId = address.get("personId");
                addresses.put(personId, address);
            }

            // write the header
            combinedWriter.writeHeader(COMBINED_HEADER);

            // read each person
            Map<String, String> person;
            final String[] personHeader = personReader.getCSVHeader(true);
            while ((person = personReader.read(personHeader)) != null) {

                // copy address details to person if they exist
                final String personId = person.get("id");
                final Map<String, String> personAddress = addresses.get(personId);
                if (personAddress != null) {
                    person.putAll(personAddress);
                }

                // write the combined details
                combinedWriter.write(person, COMBINED_HEADER);
            }

        } finally {
            personReader.close();
            addressReader.close();
            combinedWriter.close();
        }

        // print the output
        System.out.println(output);

    }
}