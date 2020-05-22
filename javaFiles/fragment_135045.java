import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

public class Sof {

    public static void main(String[] args) {
        CSVReader reader;
        try (CSVWriter writer = new CSVWriter(new FileWriter(new File("src/main/resources/test2.csv")), ';', Character.MIN_VALUE, '\\', "\n");) {
            reader = new CSVReaderBuilder(new InputStreamReader(new FileInputStream("src/main/resources/test.csv"), StandardCharsets.UTF_8))
                    .withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build();
            final List<String[]> csvBody = reader.readAll();
            System.out.println(csvBody.size());
            csvBody.get(1)[0] = ",";
            writer.writeAll(csvBody);
            writer.flush();
            reader.close();
        } catch (final IOException e1) {
            System.err.println(e1);
        }

    }

}