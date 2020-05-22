import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        // read JSON
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(jsonFile);
        JsonNode patient = root.get("PATIENT");

        // Write CSV
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.builder()
                .addColumn("age", CsvSchema.ColumnType.NUMBER)
                .addColumn("name")
                .setUseHeader(true)
                .build();
        try (SequenceWriter sequenceWriter = csvMapper.writer().with(schema).writeValues(System.out)) {
            patient.elements().forEachRemaining(node -> {
                try {
                    sequenceWriter.write(node);
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            });
        }
    }
}