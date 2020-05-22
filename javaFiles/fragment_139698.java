import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

public class GsonApp {

    public static void main(String[] args) throws IOException {
        File store = Files.createTempFile("store", "json").toFile();

        // Add two users
        JsonFileAppender jsonFileAppender = new JsonFileAppender();
        jsonFileAppender.appendToObject(store, "jon", "ewemn!32");
        jsonFileAppender.appendToObject(store, "rick", "923djks");

        // Print whole file
        System.out.println(String.join("", Files.readAllLines(store.toPath())));
    }
}

class JsonFileAppender {
    private final Gson gson;

    public JsonFileAppender() {
        this.gson = new GsonBuilder().create();
    }

    public void appendToObject(File jsonFile, String username, String password) throws IOException {
        Objects.requireNonNull(jsonFile);
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);
        if (jsonFile.isDirectory()) {
            throw new IllegalArgumentException("File can not be a directory!");
        }

        JsonObject node = readOrCreateNew(jsonFile);
        node.addProperty(username, password);

        writeToFile(jsonFile, node);
    }

    private JsonObject readOrCreateNew(File jsonFile) throws IOException {
        if (jsonFile.exists() && jsonFile.length() > 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
                return gson.fromJson(reader, JsonObject.class);
            }
        }

        return new JsonObject();
    }

    private void writeToFile(File jsonFile, JsonObject node) throws IOException {
        try (FileWriter writer = new FileWriter(jsonFile)) {
            gson.toJson(node, writer);
        }
    }
}