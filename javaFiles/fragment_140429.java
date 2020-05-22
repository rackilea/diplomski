class ResponseJsonDeserializer extends JsonDeserializer<Response>  {
  @Override
  public Responsedeserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    Response response = new Response();
    if(jp.getCurrentToken() == JsonToken.VALUE_STRING) {
        response.setError(jp.getText());
    } else {
       // Deserialize object
    }
    return response;
  }
}

class Response {
   private String error;
   private Object otherObject; // Use the real type of your object

   public boolean isError() {
      return error != null;
   }

   // Getters and setters

}