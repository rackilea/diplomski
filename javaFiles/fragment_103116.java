[…]
private String nationality;

@JsonProperty("nationality")
public String getNationality() {
    return nationality;
}

@JsonProperty("Country")
public void setNationality(String nationality) {
    this.nationality = nationality;
}
[…]