public class ResponseDTO {

    private String Id;
    private String text;
    private String explanation;

    //getters and setters;

    @JsonProperty("explanation")
    private void unpackExplanation(JsonNode explanation) {
        this.explanation = explanation.toString();
    }
}