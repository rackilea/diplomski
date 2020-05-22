package stackoverflow.questions;

import java.lang.reflect.Type;
import java.util.List;

import stackoverflow.questions.Test.Wrapper;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class Q20118749 {

   /**
    * @param args
    */
   public static void main(String[] args) {
      String json = "{\"values\":[[1,1,0,0,0,0,11,0.09090909090909091],[[0,0,0,0,0,1,0],[0,0,0,0,0,1,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,11,0],[0,0,0,0,0,0.09090909090909091,0]]]}";

      JsonElement je = new JsonParser().parse(json);
      JsonArray list = je.getAsJsonObject().get("values").getAsJsonArray(); // to get rid of the value part

      Type listType1 = new TypeToken<List<Double>>() {}.getType();
      Type listType2 = new TypeToken<List<List<Double>>>() {}.getType();

      Gson g = new Gson();

      List<Double> listOfDouble = g.fromJson(list.get(0), listType1);
      List<List<Double>> listOfListOfDouble = g.fromJson(list.get(1), listType2);

      System.out.println(listOfDouble);
      System.out.println(listOfListOfDouble);
   }

}