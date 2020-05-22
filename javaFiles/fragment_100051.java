private String name;

@JsonProperty("name")
public String thismethodwontworkwithoutjsonproperty() {
    return this.name;
}