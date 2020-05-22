public static void main(String[] args) throws IOException {

    ObjectMapper mapper = new ObjectMapper();

    // global setting, can be overridden using @JsonFormat in beans
    // when using @JsonFormat on fields, then this is not needed 
    mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    ResponseDto dto =  mapper.readValue(stringResponse, ResponseDto.class);
}