package stackoverflow.questions.q15614008;

import com.google.gson.*;

public class Q15614008 {

  public static void main(String[] arg) {

    String testString = "{\"log\": "
        + "  {"
        + "\"childId\":2," + "\"adultId\":1,"
        + "\"logoutDate\":null,"
        + "\"platform\":\"IPHONE\","
        + "\"regId\":null,"
        + "\"loginDate\":1325419200000,"
        + "\"clientApp\":\"CHILD_APP\"}"
        + "}";

    Gson gson = new Gson();
    Foo foo = gson.fromJson(
        testString, Foo.class);
    System.out.println("Result: " + foo.log.toString());
  }

}