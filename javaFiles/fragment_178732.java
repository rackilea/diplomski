private String blah;

@JsonProperty("blah")
@JsonSerialize(include = Inclusion.NON_NULL)
public String getBlah() {
    return blah;
}

@JsonProperty("blah")
public void setBlah(String blah) {
    this.blah = blah;
}