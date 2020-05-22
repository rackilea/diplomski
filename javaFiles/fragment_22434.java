@JsonCreator
public User(@JsonProperty("name") String name,
            @JsonProperty("email") String email,
            @JsonProperty("password") String password) {
    this.name = name;
    this.email = email;
    this.creationDate = new Date();
    this.passwordHash = hashPassword(password, getCreationDate());
}