generator.writeStartObject();
generator.writeFieldName("result");

objectMapper.writeValue(generator, configuration);

generator.writeEndObject();