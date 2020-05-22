package stackoverflow.questions;

import java.lang.reflect.Type;
import java.util.*;

import stackoverflow.questions.Q20254329.*;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class Q20327670 {

   static class Complex implements Recursive {
      Map<String, Recursive> map;

      @Override
      public String toString() {
         return "Complex [map=" + map + "]";
      }

   }

   static class Simple implements Recursive {

      @Override
      public String toString() {
         return "Simple []";
      }
   }

   public static class RecursiveDeserializer implements JsonDeserializer<Recursive> {

      public Recursive deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
         Recursive r = null;
         if (json == null)
            r = null;
         else {
            JsonElement t = json.getAsJsonObject().get("type");
            String type = null;
            if (t != null) {
               type = t.getAsString();

               switch (type) {
               case "complex": {
                  Complex c = new Complex();
                  JsonElement e = json.getAsJsonObject().get("map");
                  if (e != null) {
                     Type mapType = new TypeToken<Map<String, Recursive>>() {}.getType();
                     c.map = context.deserialize(e, mapType);
                  }
                  r = c;
                  break;
               }
               case "simple": {
                  r = new Simple();
                  break;
               }
               // remember to manage default..
               }

            }
         }
         return r;
      }

   }

   public static void main(String[] args) {
      String json = " {                                         " + 
                    "    \"type\" : \"complex\",                " + 
                    "    \"map\" : {                            " + 
                    "       \"a\" : {                           " +
                    "          \"type\" : \"simple\"            " +
                    "       },                                  " + 
                    "       \"b\" : {                           " +
                    "          \"type\" : \"complex\",          " + 
                    "          \"map\" : {                      " + 
                    "              \"ba\" : {                   " +
                    "                  \"type\" : \"simple\"    " +
                    "          }                                " +
                    "       }                                   " +
                    "    }                                      " +
                    "  }  }                                     ";

      GsonBuilder gb = new GsonBuilder();
      gb.registerTypeAdapter(Recursive.class, new RecursiveDeserializer());

      Gson gson = gb.create();
      Recursive r = gson.fromJson(json, Recursive.class);

      System.out.println(r);

   }

}