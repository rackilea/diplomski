public static void main (String [] args) throws IOException
{
  ObjectMapper mapper = new ObjectMapper (); // can reuse, share globally
  mapper.configure (Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
  JsonNode tree = mapper.readTree (new File ("foo.json"));
  // assuming "edges" is a property of the root object
  final JsonNode edges = tree.get ("edges");
  for (JsonNode edge : edges)
  {
    final double lat = edge.get ("lat").asDouble ();
    final double dr = edge.get ("dr").asDouble ();
    final double geodistance = edge.get ("geodistance").asDouble ();
  }
}