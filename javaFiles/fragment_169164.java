@JsonIgnoreProperties(ignoreUnknown = true)
class Response {
    List<Weather> list;

    //general getters and setters
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Weather {
    JsonNode main;
    JsonNode wind;

    @JsonProperty("dt_txt")
    String dtTxt;

    //general getters and setters
}