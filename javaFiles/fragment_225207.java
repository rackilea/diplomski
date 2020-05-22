ObjectMapper om = ...;

JsonNode node = arg0.readValueAs(JsonNode.class);
try
{
    return om.readValue(node, new TypeReference<List<C>>(){});
}
catch (JsonMappingException jme)
{
}
return null;