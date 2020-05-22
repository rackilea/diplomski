class MyComboItem {
   private String productId;
   private String productName;

   public MyComboItem(String productId, String productName) {
      this.productId = productId;
      this.productName = productName;
   }

   public String getProductId() {
      return productId;
   }

   public String getProductName() {
      return productName;
   }

   @Override
   public String toString() {
      return productName;
   }
}