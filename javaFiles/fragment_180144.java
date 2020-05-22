ObjectMapper mapper = new ObjectMapper();
 TypeReference<Properties> buildVersionsTypeReference = new TypeReference<Properties>() { };
 Object object = mapper.readValue(jsonString, typeRef);
 if (object instanceof Properties) {
        return (Properties) object;
  }