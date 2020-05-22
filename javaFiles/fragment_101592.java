// -*- compile-command: "javac -cp javax.json-1.0.jar q43737601.java && java -cp .:javax.json-1.0.jar q43737601"; -*-

import java.io.FileReader;
import javax.json.Json;
import javax.json.stream.JsonParser;

class q43737601
{
  public static void main (String argv[]) throws Exception
  {
    String path = "config.json";
    int sum = 0;

    JsonParser p = Json.createParser (new FileReader (path));
    while (p.hasNext()) {
      JsonParser.Event e = p.next();
      switch (e) {
      case VALUE_NUMBER:
        sum += Integer.parseInt(p.getString());
        break;
      case KEY_NAME:
        if ("Type".equals(p.getString()))
          System.out.println(sum);
        break;
      }
    }
  }
}