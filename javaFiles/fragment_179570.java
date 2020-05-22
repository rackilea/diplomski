final ObjectMapper mapper = new ObjectMapper();
   final ArrayType type = mapper.getTypeFactory().constructArrayType(Map.class);

   try {
       if (attrBlockName == null || attrBlockName.length() == 0)
           return mapper.readValue(f, type);
       JsonNode base = new ObjectMapper().readTree(f);
       if (base == null)
           return JSonHttpClientAttributeProvider.PROVIDER_FAILED_UNKNOWN;
       JsonNode attrJson = base.get(attrBlockName);
       if (attrJson == null)
           return JSonHttpClientAttributeProvider.PROVIDER_FAILED_UNKNOWN;
       Map<String, String>[] mapArray = mapper.readValue(mapper.treeAsTokens(attrJson), type);
       for (Map<String, String> newmap : mapArray) {
           if (newmap.containsKey(attrNameField) && newmap.containsKey(attrValueField))
               map.put(newmap.get(attrNameField), newmap.get(attrValueField));
       }
       return PROVIDER_SUCCEEDED;
   } catch (IOException ioe) {
       throw new MyExceptionClass("Exception occurred during request", ioe);
   }