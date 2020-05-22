package stackoverflow.questions;

import java.util.*;

import com.google.gson.Gson;

public class Q20461706 {

   public class Trace {
      ArrayList<Message> messages;
      ArrayList<Scenario> scenarios;
      @Override
      public String toString() {
         return "Trace [messages=" + messages + ", scenarios=" + scenarios + "]";
      }

   }

   public static class Message {
      String from; // "from": "dudu",
      String method; // "method": "call()",
      String scenario; // "scenario": "#1",
      String timestamp; // "timestamp": "09-12-2013 00:21:14",
      String to; // "to": "dudu",
      String type; // "type": "void",
      Boolean violation; // "violation": "true",
      Boolean visible; // "visible": "true"
      @Override
      public String toString() {
         return "Message [from=" + from + ", method=" + method + ", scenario=" + scenario + ", timestamp=" + timestamp + ", to=" + to + ", type=" + type + ", violation=" + violation + ", visible=" + visible + "]";
      }


   }

   public static class Scenario {
      String name;// "name": "testscenario",
      String id; // "id": "#1",
      String description; // "description": "testing parsing!"
      @Override
      public String toString() {
         return "Scenario [name=" + name + ", id=" + id + ", description=" + description + "]";
      }

   }

   public static class Component {
      String fullname; // "fullname": "CC/dudu",
      String name; // "name": "dudu",
      String type; // "type": "String",
      List<Component> children;
      @Override
      public String toString() {
         return "Component [fullname=" + fullname + ", name=" + name + ", type=" + type + ", children=" + children + "]";
      }

   }

   public static class Visualization {
      Component root;
      Trace traces;
      @Override
      public String toString() {
         return "Visualization [root=" + root + ", traces=" + traces + "]";
      }

   }

   public static class Response {
      Visualization visualization;

      @Override
      public String toString() {
         return "Response [visualization=" + visualization + "]";
      }

   }

   public static void main(String[] args) {
      String json = 
     " {\"visualization\": {                                   "+
     "    \"root\": {                                          "+
     "        \"fullname\": \"CC/dudu\",                       "+
     "        \"name\": \"dudu\",                              "+
     "        \"type\": \"String\",                            "+
     "        \"children\": [                                  "+
     "            {                                            "+
     "                \"fullname\": \"CC/dudu/lulu\",          "+
     "                \"name\": \"lulu\",                      "+
     "                \"type\": \"String\"                     "+
     "            }                                            "+
     "        ]                                                "+
     "    },                                                   "+
     "    \"traces\": {                                        "+
     "        \"messages\": [                                  "+
     "            {                                            "+
     "                \"from\": \"dudu\",                      "+
     "                \"method\": \"call()\",                  "+
     "                \"scenario\": \"#1\",                    "+
     "                \"timestamp\": \"09-12-2013 00:21:14\",  "+
     "                \"to\": \"dudu\",                        "+
     "                \"type\": \"void\",                      "+
     "                \"violation\": \"true\",                 "+
     "                \"visible\": \"true\"                    "+
     "            }                                            "+
     "        ],                                               "+
     "        \"scenarios\": [                                 "+
     "            {                                            "+
     "                \"name\": \"testscenario\",              "+
     "                \"id\": \"#1\",                          "+
     "                \"description\": \"testing parsing!\"    "+
     "            }                                            "+
     "        ]                                                "+
     "    }                                                    "+
     "    }}                                                   ";

      Gson gsonParser = new Gson();

      Response r = gsonParser.fromJson(json, Response.class);

      System.out.println(r);


   }

}