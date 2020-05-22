class NullSerializer extends JsonSerializer<Object>
{
  @Override
  public void serialize(Object obj, JsonGenerator jsonGen, SerializerProvider unused) 
      throws IOException, JsonProcessingException
  {
    jsonGen.writeFieldName("");
  }
}