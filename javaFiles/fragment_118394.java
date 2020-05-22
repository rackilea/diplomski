@JsonCreator
    public Customer(
            @JsonProperty("name") String name,
            @JsonProperty("age")  int age,
            @JsonProperty("street") String street,
            @JsonProperty("postalcode")   String postalcode
    ) {
        this.name = name;
        this.age = age;
        this.address = new Address();
        this.address.street = street;
        this.address.postalcode = postalcode;
    }