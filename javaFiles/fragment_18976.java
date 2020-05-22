OpenAPI swagger = new OpenAPIV3Parser().read("url to Open API 3.0 Swagger")
Map < String, Schema > definitions = swagger.getComponents().getSchemas()
Schema model = definitions.get("Pet")
Example example = ExampleBuilder.fromSchema(model, definitions)
SimpleModule simpleModule = new SimpleModule().addSerializer(new JsonNodeExampleSerializer())
Json.mapper().registerModule(simpleModule)
String jsonExample = Json.pretty(example);
System.out.println(jsonExample);