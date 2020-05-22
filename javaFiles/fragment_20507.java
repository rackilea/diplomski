package com.another;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class NewClass {

    public static final String inputString = "[ [\"task1\", 10, 99],   [\"task2\", 10, 99],   [\"task3\", 10, 99],   [\"task1\", 11, 99],   [\"task2\", 11, 99],   [\"task3\", 11, 99]]";

    public static void main(String[] args) throws ParseException {
        JSONArray obj = (JSONArray) new JSONParser().parse(inputString);
        Map<Object, JSONObject> output = new HashMap<Object, JSONObject>();
        for (Object o : obj) {
            JSONArray item = (JSONArray) o;
            Object title = item.get(0);
            Object first = item.get(1);
            Object second = item.get(2);
            JSONObject dest = output.get(title);
            if (dest == null) {
                dest = new JSONObject();
                output.put(title, dest);
                dest.put("label", title);
                dest.put("data", new JSONArray());
            }
            JSONArray data = new JSONArray();
            data.add(first);
            data.add(second);
            ((JSONArray) dest.get("data")).add(data);
        }
        String outputString = JSONArray.toJSONString(Arrays.asList(output.values().toArray()));
        System.out.println(outputString);
    }
}