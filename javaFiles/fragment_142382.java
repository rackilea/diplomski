@JsonIgnoreProperties({"location"})
abstract class FirstFormat {
}

abstract class SecondFormat {
    @JsonProperty("user")
    public abstract void setName(String name);
    @JsonProperty("mail")
    public abstract void setEmail(String email);
    public abstract void setAge(int age);
}

abstract class ThirdFormat {
    @JsonProperty("who")
    public abstract void setName(String name);
    @JsonProperty("contacts")
    public abstract void setEmail(String email);
    public abstract void setAge(int age);
}