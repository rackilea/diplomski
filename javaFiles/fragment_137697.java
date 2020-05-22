@Override
public void serializeWithType(IPet value, JsonGenerator gen, 
        SerializerProvider provider, TypeSerializer typeSer) 
        throws IOException, JsonProcessingException {

  typeSer.writeTypePrefixForObject(value, gen);
  serialize(value, gen, provider); // call your customized serialize method
  typeSer.writeTypeSuffixForObject(value, gen);
}