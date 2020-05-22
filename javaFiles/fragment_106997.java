class Converter {
    private String date;
    private JsonNode rates;
    private String base;

    //general getters and setters
}


ObjectMapper mapper = new ObjectMapper();
Converter converterGbp = mapper.readValue(jsonGbp, Converter.class);
System.out.println(converterGbp.getRates().get("GBP").asText()); //0.7614025599