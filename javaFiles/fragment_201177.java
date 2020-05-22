public class Data<T> {
    // property name, that will be changed
    @JsonProperty(DataNamingStrategy.DATA_FIELD)
    private T[] data;
    // Getters Setters Constructors
}