@JsonSerialize(using = WrapperSerializer.class)
class Wrapper {
    private String key;
    private String value;
    // getters, setters, all args constructors
}