try (JsonGenerator generator = new JsonFactory().createGenerator(writer)) {
     generator.writeStartObject();
     generator.writeFieldName("value");
     generator.writeString("123");
     generator.writeEndObject();
  }
}