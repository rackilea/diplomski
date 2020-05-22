@JsonCreator
public Thing(@JsonProperty("symbol") String symbol, 
             @JsonProperty("name") String name) {

    this.symbol = symbol;
    this.name = name;
}