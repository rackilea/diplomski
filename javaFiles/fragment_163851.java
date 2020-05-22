import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class CsvApp {

    public static void main(String[] args) throws Exception {
        File formatFile = new File("./resource/test.format").getAbsoluteFile();
        File csvFile = new File("./resource/test.csv").getAbsoluteFile();

        CsvSchema schema = createSchemaForFormat(formatFile);

        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<Record> rows = csvMapper.readerFor(Record.class).with(schema).readValues(csvFile);

        RecordCollection recordCollection = new RecordCollection(100);
        while (rows.hasNext()) {
            recordCollection.add(rows.next());
        }

        recordCollection.getRecords().forEach((k, v) -> {
            System.out.println(k + " => " + v);
        });
    }

    private static CsvSchema createSchemaForFormat(File formatFile) throws IOException {
        String content = String.join("", Files.readAllLines(formatFile.toPath()));
        String[] columns = content.split(",");

        CsvSchema.Builder builder = CsvSchema.builder();
        for (String column : columns) {
            String[] columnData = column.split(":");
            String name = columnData[0];
            String type = columnData[1];
            builder.addColumn(name, "Integer".equalsIgnoreCase(type) ? CsvSchema.ColumnType.NUMBER : CsvSchema.ColumnType.STRING);
        }

        return builder.build();
    }
}

class RecordCollection {

    private final Map<String, Record> records;

    RecordCollection(int expectedSize) {
        this.records = new HashMap<>(expectedSize);
    }

    public void add(Record record) {
        this.records.put(record.getId(), record);
    }

    public Map<String, Record> getRecords() {
        return records;
    }
}

class Record {

    private final String id;
    private final String name;
    private final String city;
    private final String state;
    private final Integer zip;

    @JsonCreator
    public Record(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("city") String city,
            @JsonProperty("state") String state,
            @JsonProperty("zip") Integer zip) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public Integer getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }
}