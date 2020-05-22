package com.stackoverflow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CsvReader {

    public static final String CSVFILE = "src/com/stackoverflow/myfile.csv";

    public static void main(String[] args) {

        String cvsSplitBy = "\\t+"; // use tab as separator

        try (Stream<String> stream = Files.lines(Paths.get(CSVFILE))) {

            stream.forEach(line -> {
                String[] info = line.split(cvsSplitBy);

                StringBuilder details = new StringBuilder();
                details.append("ID = ");
                details.append(info[0]);
                details.append(", Country = ");
                details.append(info[1]);

                System.out.println(details.toString());
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}