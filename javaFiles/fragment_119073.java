public class Cleanup {
  ...

  public void cleanupData(Writer output) {
     ObjectMapper mapper = new ObjectMapper();
     mapper.enable(SerializationFeature.INDENT_OUTPUT);
     mapper.writeValue(output, list);
  } 

  ...
}