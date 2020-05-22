public class SearchResponse<T> { // T is a type variable
    @SerializedName("error")
    @Expose
    private Integer error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<T> data; // We have a list of T

    (Getter and Setter here)
}