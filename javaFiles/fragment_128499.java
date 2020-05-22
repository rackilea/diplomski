import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JsonWritingProject {

    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();

        try {
            Object obj = jsonParser.parse(new FileReader("D:\\student.json"));
            JSONArray jsonArray = (JSONArray)obj;

            System.out.println(jsonArray);

            JSONObject student1 = new JSONObject();
            student1.put("name", "BROCK");
            student1.put("age", new Integer(3));

            JSONObject student2 = new JSONObject();
            student2.put("name", "Joe");
            student2.put("age", new Integer(4));

            jsonArray.add(student1);
            jsonArray.add(student2);

            System.out.println(jsonArray);

            FileWriter file = new FileWriter("D:\\student.json");
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

    }
}