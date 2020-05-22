public class SearchRequest {
    @NotEmpty(message="product category is empty")
    private int productCategory;
    @NotEmpty(message="user name is empty")
    private int userName;
}

public String search(@RequestBody @Valid SearchRequest search) {
    ...
}