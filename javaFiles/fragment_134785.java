public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
    FileInputStream fis = new FileInputStream("src/main/resources/photocameras.json");
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    ItemsDTO<PhotocameraDTO> itemsDto = objectMapper.readValue(fis, new TypeReference<ItemsDTO<PhotocameraDTO>>() {});
    List<PhotocameraDTO> photocameras = itemsDto.getItems();
    System.out.println(photocameras);
}