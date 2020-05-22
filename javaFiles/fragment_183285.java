public static void main(String... args) throws Exception {
  ObjectMapper mapper = new ObjectMapper();
  Response r1 = new Response("Error", "Some error", 20);
  System.out.println(mapper.writeValueAsString(r1));
  Response r2 = new Response("Error", "Some error", "some string");
  System.out.println(mapper.writeValueAsString(r2));
}