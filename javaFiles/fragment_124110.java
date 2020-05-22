package stackoverflow.questions.q19997365;

import com.google.gson.*;

public class Q19997365 {

   public static class Person {
      String id;
      String name;

      @Override
      public String toString() {
         return "Person [id=" + id + ", name=" + name + "]";
      }
   }

   public static class Account {
      String accountid;
      String accountnumber;

      @Override
      public String toString() {
         return "Account [accountid=" + accountid + ", accountNumber=" + accountnumber + "]";
      }

   }

   public static class Transaction {
      String id;
      String date;

      @Override
      public String toString() {
         return "Transaction [id=" + id + ", date=" + date + "]";
      }

   }

   /**
    * @param args
    */
   public static void main(String[] args) {
      String json1 = "{\"id\" : \"1\", \"name\" : \"David\"}"; // this represent testdata for the class Person
      String json2 = "{\"accountid\" : \"1188\", \"accountnumber\" : \"119295567\"}"; // this represent testdata for the class account
      String json3 = "{\"id\" : \"22\", \"date\" : \"22.11.2013\"}"; // this represent testdata for the class transaction

      System.out.println(extractFromJson(json1));
      System.out.println(extractFromJson(json2));
      System.out.println(extractFromJson(json3));

   }

   private static Object extractFromJson(String json) {
      Gson g = new Gson();
      JsonObject e = new JsonParser().parse(json).getAsJsonObject();
      if (e.get("name") != null)
         return g.fromJson(json, Person.class);
      if (e.get("accountid") != null)
         return g.fromJson(json, Account.class);
      if (e.get("date") != null)
         return g.fromJson(json, Transaction.class);

      return null;
   }

}