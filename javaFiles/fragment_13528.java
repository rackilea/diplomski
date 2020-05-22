public class Response {
    @SerializedName("results")
    @Expose
    private Collection<Result> results;
    @SerializedName("address_components")
    @Expose
    private String status;
    // getters/setter
}