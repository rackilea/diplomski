class Tester
{
  public static void main(String[] args) throws Exception {
    String s1 = "{\"fields\": [ { \"id\": 261762251, \"value\": \"Fred\" }, { \"id\": 261516162, \"value\": \"Dave\" }]}";
    ObjectMapper om = new ObjectMapper();
    Myclass mine = om.readValue(s1, Myclass.class);
    System.out.println(mine);
  }
}


public class User {

   private String age;
   private String country;
   private String firstname; // this is the field in the list that needs converting
   @JsonProperty("fields")
   private void unpackNested(List<Map<String,Object>> fields) {
     for(Map<String,Object> el: fields) {
       if((Integer)el.get("id") == 261762251) {
          firstname = el.toString();
            }
          }
        }
   // getters and setters
}