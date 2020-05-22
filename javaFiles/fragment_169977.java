package stackoverflow.questions;

import java.lang.reflect.Type;
import java.util.*;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class Q20337652 {

   public static class Term {
      String term;
      String POS;
      String sense;
      String usage;

      @Override
      public String toString() {
         return "Term [term=" + term + ", POS=" + POS + ", sense=" + sense + ", usage=" + usage + "]";
      }


   }

   public static class Item {
      Term OriginalTerm;
      Term FirstTranslation;
      String Note;

      @Override
      public String toString() {
         return "Item [OriginalTerm=" + OriginalTerm + ", FirstTranslation=" + FirstTranslation + ", Note=" + Note + "]";
      }


   }



   public static void main(String[] args){

          String json =                                                                                                                                 
    "  {                                                                                                                                   "+
    "                                                                                                                                      "+
    "     \"term0\" : {                                                                                                                    "+
    "     \"PrincipalTranslations\" : {                                                                                                    "+
    "         \"0\" :{                                                                                                                     "+
    "             \"OriginalTerm\" : { \"term\" : \"cat\", \"POS\" : \"n\", \"sense\" : \"domestic animal\", \"usage\" : \"\"},            "+
    "             \"FirstTranslation\" : {\"term\" : \"gato\", \"POS\" : \"nm\", \"sense\" : \"  \"}, \"Note\" : \"\"},                    "+
    "         \"1\" :{                                                                                                                     "+
    "             \"OriginalTerm\" : { \"term\" : \"cat\", \"POS\" : \"n\", \"sense\" : \"member of cat family\", \"usage\" : \"\"},       "+
    "             \"FirstTranslation\" : {\"term\" : \"felino\", \"POS\" : \"nm\", \"sense\" : \"familia de animales\"}, \"Note\" : \"\"}},"+
    "     \"AdditionalTranslations\" : {                                                                                                   "+
    "         \"0\" :{                                                                                                                     "+
    "             \"OriginalTerm\" : { \"term\" : \"cat\", \"POS\" : \"n\", \"sense\" : \"guy\", \"usage\" : \"slang\"},                   "+
    "             \"FirstTranslation\" : {\"term\" : \"tío, tipo, chaval\", \"POS\" : \"nm\", \"sense\" : \"coloq\"},                      "+
    "             \"SecondTranslation\" : {\"term\" : \"vato\", \"POS\" : \"\", \"sense\" : \"Mex\"}, \"Note\" : \"\"},                    "+
    "                                                                                                                                      "+
    "     \"original\" : {                                                                                                                 "+
    "     \"Compounds\" : {                                                                                                                "+
    "         \"0\" :{                                                                                                                     "+
    "             \"OriginalTerm\" : { \"term\" : \"alley cat\", \"POS\" : \"n\", \"sense\" : \"stray cat\", \"usage\" : \"\"},            "+
    "             \"FirstTranslation\" : {\"term\" : \"gato callejero\", \"POS\" : \"nm\", \"sense\" : \"\"}, \"Note\" : \"\"},            "+
    "     \"Lines\" : \"End Reached\", \"END\" : true                                                                                      "+
    "                                                                                                                                      "+
    " }                                                                                                                                    "+
    " }     }}}                                                                                                                               ";
      JsonParser jp = new JsonParser();
      JsonElement je = jp.parse(json);
      JsonElement je2 = je.getAsJsonObject().get("term0");
      JsonElement je3 = je2.getAsJsonObject().get("PrincipalTranslations");

      Type mapType = new TypeToken<Map<String, Item>>() {}.getType();

      Map<String, Item> principalTranslation = new Gson().fromJson(je3, mapType);

      System.out.println(principalTranslation);


   }

}