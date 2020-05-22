package ca.junctionbox.soavro;

import org.apache.avro.Schema;
import org.apache.avro.SchemaValidationException;
import org.apache.avro.SchemaValidationStrategy;
import org.apache.avro.SchemaValidator;
import org.apache.avro.SchemaValidatorBuilder;

import java.util.ArrayList;

public class Main {
    public static final String V1 = "{\n" +
            "    \"type\": \"record\",\n" +
            "    \"name\": \"pouac\",\n" +
            "    \"fields\": [\n" +
            "        {\n" +
            "            \"name\": \"test1\",\n" +
            "            \"type\": \"int\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"test2\",\n" +
            "            \"type\": \"int\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    public static final String V2 = "{\n" +
            "    \"type\": \"record\",\n" +
            "    \"name\": \"pouac\",\n" +
            "    \"fields\": [{\n" +
            "        \"name\": \"test2\",\n" +
            "         \"type\": \"int\",\n" +
            "         \"aliases\": [\"test1\"]\n" +
            "    }]\n" +
            "}";

    public static void main(final String[] args) {
        final SchemaValidator sv = new SchemaValidatorBuilder()
                .canBeReadStrategy()
                .validateAll();
        final Schema sv1 = new Schema.Parser().parse(V1);
        final Schema sv2 = new Schema.Parser().parse(V2);
        final ArrayList<Schema> existing = new ArrayList<>();
        existing.add(sv1);

        try {
            sv.validate(sv2, existing);
            System.out.println("Good to go!");
        } catch (SchemaValidationException e) {
            e.printStackTrace();
        }
    }
}