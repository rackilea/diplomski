package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import java.util.HashMap;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class JacksonStreamAPIExample {

    static String PROBLEM_LIST_FILE_PATH = "F:\\kaidul.txt";
    static String COMPETITIVE_PROGRAMMING_BOOK_PATH = "F:\\competitive_programming_edition_3.json";
    static String TARGET_PATH = "F:\\test.json";

    static HashMap<Integer, String> problems = new HashMap<Integer, String>();

    public static void main(String[] args) {
        // Mapping problem No with problem Title
        InputStream is = null;
        try {
            is = new FileInputStream(PROBLEM_LIST_FILE_PATH);
        } catch (FileNotFoundException e) {

        }
        try {
            JsonReader reader  = new JsonReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            reader.beginArray();
            while (reader.hasNext()) {
                reader.beginArray();
                reader.skipValue();
                problems.put(reader.nextInt(), reader.nextString());
                reader.skipValue();
                while (reader.hasNext())
                    reader.skipValue();
                reader.endArray();
            }
            reader.endArray();
            reader.close();
        } catch (IOException e) {
        }

        // Reading and modifying
        JsonWriter writer = null;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(COMPETITIVE_PROGRAMMING_BOOK_PATH);

            JsonReader reader = new JsonReader(new InputStreamReader(
                    inputStream));
            writer = new JsonWriter(new FileWriter(TARGET_PATH));

            reader.beginArray(); // array #1
            writer.beginArray();
            while (reader.hasNext()) {
                reader.beginObject(); // object #2
                writer.beginObject();
                while (reader.hasNext()) {
                    reader.skipValue();
                    writer.name("title").value(reader.nextString());
                    reader.skipValue();
                    writer.name("arr");
                    reader.beginArray(); // array #3
                    writer.beginArray();
                    while (reader.hasNext()) {
                        reader.beginObject(); // object #4
                        writer.beginObject();
                        while (reader.hasNext()) {
                            reader.skipValue();
                            writer.name("title").value(reader.nextString());
                            reader.skipValue();
                            writer.name("arr");
                            reader.beginArray(); // array #5
                            writer.beginArray();
                            while (reader.hasNext()) {
                                reader.beginArray(); // array #6
                                writer.beginArray();
                                writer.value(reader.nextString());
                                while (reader.hasNext()) {
                                    int problemNo = reader.nextInt();
                                    writer.value(problemNo);
                                    writer.value(problems.get(Math.abs(problemNo))); // additional problemTitle
                                }
                                reader.endArray(); // array #6
                                writer.endArray();
                            }
                            reader.endArray(); // array #5
                            writer.endArray();
                        }
                        reader.endObject(); // object #4
                        writer.endObject();
                    }
                    reader.endArray(); // array #3
                    writer.endArray();
                }
                reader.endObject(); // object #2
                writer.endObject();
            }
            reader.endArray(); // array #1
            writer.endArray();
            reader.close();
            writer.close();
        } catch (IOException e) {
            // nothing
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // nothing
                }
            }
        }
    }
}