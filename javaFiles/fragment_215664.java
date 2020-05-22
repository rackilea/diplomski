ObjectMapper m = new ObjectMapper();
SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
m.acceptJsonFormatVisitor(m.constructType(Phone.class), visitor);
JsonSchema jsonSchema = visitor.finalSchema();

ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
mapper.writeValue(yamlFile, jsonSchema);