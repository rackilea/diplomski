public List<Film> convert(String jsonString) throws JsonParseException, JsonMappingException,
            IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        List<Film> filmList = objectMapper.readValue(
                jsonString,
                objectMapper.getTypeFactory().constructCollectionType(
                        List.class, Film.class));

   return filmList;
    }