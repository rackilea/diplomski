package stackoverflow.questions.q19124387;

import java.util.Map;

import com.google.gson.*;

public class Q20624042 {

   private static String printClass(JsonElement je, String ident) {
      StringBuilder sb = null;
      if (je.isJsonNull())
         return "null";

      if (je.isJsonPrimitive()) {
         if (je.getAsJsonPrimitive().isBoolean())
            return "Boolean";
         if (je.getAsJsonPrimitive().isString())
            return "String";
         if (je.getAsJsonPrimitive().isNumber()){
            return "Number";
         }
      }

      if (je.isJsonArray()) {
         sb = new StringBuilder("array<");
         for (JsonElement e : je.getAsJsonArray()) {
            sb.append(printClass(e, ident+ "    "));
         }
         sb.append(">");
         return sb.toString();
      }

      if (je.isJsonObject()) {
         sb = new StringBuilder("map<\n");
         for (Map.Entry<String, JsonElement> e : je.getAsJsonObject().entrySet()) {
            sb.append(ident);
            sb.append(e.getKey()).append(":");
            sb.append(printClass(e.getValue(), ident+"   "));
            sb.append("\n");
         }
         sb.append(ident);
         sb.append(">");
         return sb.toString();
      }
      return "";

   }

   public static void main(String[] args) {
      String json = "{" + "\"number\":1," + "\"ts\":\"1386848002\"," + "\"cmpg\":[{\"id\":476,\"mcp\":0.0000,\"deals\":[],\"cookie\":\"uid:123\",\"bid\":[{\"bId\":0,\"status\":\"ZB\",\"rmtchID\":-1}]}]}";

      JsonElement je = new JsonParser().parse(json);
      System.out.println(printClass(je,"   "));

   }

}