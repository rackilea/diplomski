public boolean validate(String jsonData, String jsonSchema, boolean useV4, boolean useId) throws Exception {
   // create the Json nodes for schema and data
   JsonNode schemaNode = JsonLoader.fromString(jsonSchema); // throws JsonProcessingException if error
   JsonNode data = JsonLoader.fromString(jsonData);         // same here

   JsonSchemaFactory factory = JsonSchemaFactories.withOptions(useV4, useId);
   // load the schema and validate
   JsonSchema schema = factory.fromSchema(schemaNode);
   ValidationReport report = schema.validate(data);

   return report.isSuccess();
}