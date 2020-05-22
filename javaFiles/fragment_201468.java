package testing;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Hello world!
 */
public class App {

    static String json = ""
 + "["
 + " {"
 + "     \"id\": 1,"
 + "     \"empid\": \"12345\","
 + "     \"details\": {"
 + "         \"name\": \"xyz\","
 + "         \"age\": \"30\","
 + "         \"sex\": \"M\","
 + "         \"Address\": {"
 + "             \"Office\": \"office\","
 + "             \"Home\": \"Home\""
 + "         }"
 + "     },"
 + "     \"abcDetails\": \"asdf\","
 + "     \"mobile\": 123455"
 + " },"
 + " {"
 + "     \"id\": 2,"
 + "     \"empid\": \"64848\","
 + "     \"details\": {"
 + "         \"name\": \"eryje\","
 + "         \"age\": 3027,"
 + "         \"sex\": \"M\","
 + "         \"Address\": {"
 + "             \"Office\": \"office\","
 + "             \"Home\": \"Home\""
 + "         }"
 + "     },"
 + "     \"abcDetails\": \"fhkdl\","
 + "     \"mobile\": 389928"
 + " }"
 + "]";

    public static void main(String[] args) throws Exception {

        JSONArray jsonarray = new JSONArray(json);
        System.out.println(String.format("JSONArray length => %d", jsonarray.length()));

        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject obj1 = jsonarray.getJSONObject(i);
            JSONObject details = obj1.getJSONObject("details");
            System.out.println(String.format("details => %s", details.toString()));

            String name = details.getString("name");
            int age = details.getInt("age");
            System.out.println(name);
            System.out.println(age);
        }
    }
}