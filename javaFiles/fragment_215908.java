public class ShopListResponse {

private List<ShopDetails> shopList;

private String message;

public ShopListResponse (List<ShopDetails> shopList, String message){
this.shopList = shopList;
this.message = message;
}

// getters and setters
}