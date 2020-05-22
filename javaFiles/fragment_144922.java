package com.unthreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;

import javax.json.Json;
import javax.json.stream.JsonParser;

public class App {

    public static void main(String[] args) throws IOException {
        StringBuilder jsonData = new StringBuilder();
        URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));) {
            String line;
            while ((line = br.readLine()) != null) {
                jsonData.append(line);
            }
        }
        new App().processUnknownJson(jsonData.toString());
    }

    private void processUnknownJson(String jsonData) {
        System.out.println("jsonData:" + jsonData);
        JsonParser parser = Json.createParser(new StringReader(jsonData));
        while (parser.hasNext()) {
            JsonParser.Event event = parser.next();
            switch (event) {
            case START_ARRAY:
            case END_ARRAY:
            case START_OBJECT:
            case END_OBJECT:
            case VALUE_FALSE:
            case VALUE_NULL:
            case VALUE_TRUE:
                System.out.println(event.toString());
                break;
            case KEY_NAME:
                System.out.print(event.toString() + " " + parser.getString() + " - ");
                break;
            case VALUE_STRING:
            case VALUE_NUMBER:
                System.out.println(event.toString() + " " + parser.getString());
                break;
            default:
                System.out.println("Unexpected event: " + event.toString());
            }
        }
    }
}