import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.util.List;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper jsonMapper = new ObjectMapper();
        Response response = jsonMapper.readValue(jsonFile, Response.class);

        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = csvMapper.schemaFor(Item.class).withHeader();
        SequenceWriter sequenceWriter = csvMapper.writer(schema).writeValues(System.out);
        sequenceWriter.writeAll(response.getRows());
    }
}

class Response {
    private List<Item> rows;

    // getters, setters
}

@JsonPropertyOrder({"id", "name", "age"})
class Item {

    private int id;
    private String name;
    private int age;

    // getters, setters
}