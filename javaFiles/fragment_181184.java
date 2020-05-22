public static void main(String[] args) throws IOException 
{
    ObjectMapper objectMapper = new ObjectMapper();
    String json= "{\"insertDataRequest\":{\"id\":98, \"name\":\"Mercer Island\",\"age\":12,\"designation\":\"SEE\"}}";
    JsonNode root2 = objectMapper.readTree(json);
    for (JsonNode rootnode : root2.get("insertDataRequest")) {
      if (rootnode.has("id")) {
          int id = rootnode.get("id").intValue();
          System.out.println(id);
      }     
      if (rootnode.has("name")) {
          String name = rootnode.get("name").toString().replace("\"", "");
          System.out.println(name);
      }   

      if (rootnode.has("age")) {
          int age = rootnode.get("age").intValue();
          System.out.println(age);
      }

      if (rootnode.has("designation")) {
          String designation = rootnode.get("designation").toString().replace("\"", "");
          System.out.println(designation);
      }    
    }
}