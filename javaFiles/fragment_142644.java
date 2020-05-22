public class SearchRequest {

    private int productCategory;

    private int userName;
}

public String search(@RequestParam("product_category") @NotEmpty(message="product category is empty") String productCategory, @RequestParam("user_name") @NotEmpty(message="user name is empty") String username) {
    ... // Code to set the productCategory and username to SearchRequest pojo.
}