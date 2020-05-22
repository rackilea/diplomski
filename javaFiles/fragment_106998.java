class Converter {
    private String date;
    private Map<String, Object> rates;
    private String base;

    //general getters and setters
}

ObjectMapper mapper = new ObjectMapper();
Converter converterGbp = mapper.readValue(jsonGbp, Converter.class);
System.out.println(converterGbp.getRates().get("GBP").toString()); //0.7614025599