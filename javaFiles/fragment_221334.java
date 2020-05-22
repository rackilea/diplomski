public void addToCart(Order order)
{
    SQLiteDatabase db = getReadableDatabase();
    String query = String.format("INSERT INTO OrderDetail(ProductId,ProductName,Quantity,Price,Discount) VALUES('%s','%s','%s','%s''%s'));",
         order.getProductId(),
         order.getProductName(),
            order.getQuantity(),
            order.getPrice(),
            order.getDiscount());
    db.execSQL(query);
}