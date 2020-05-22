String data = "{\"Labels\": {\"com.example.vendor\": \"Acme\",\"com.example.license\": \"GPL\",\"com.example.version\": \"1.0\"}}";

ObjectMapper mapper = new ObjectMapper();
mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
Labels labels = mapper.readValue(data, Labels.class);
System.out.println(labels);