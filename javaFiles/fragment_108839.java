Uri.Builder builder = new Uri.Builder();
builder.scheme("http")
    .authority("yehki.epagestore.in")
    .appendPath("app_api")
    .appendPath("order.php")
    .appendQueryParameter("customer_id", customer_id)
    .appendQueryParameter("address_id", address_id);

for (int i = 0; i < carts.length(); i++) {
   builder.appendQueryParameter("products["+i+"][productName]", cartList.get(i).get((Const.TAG_PRODUCT_NAME)));
   builder.appendQueryParameter("products["+i+"][productId]", cartList.get(i).get((Const.TAG_PRODUCT_ID)));
   builder.appendQueryParameter("products["+i+"][quantity]", cartList.get(i).get((Const.TAG_QUANTITY)));
   builder.appendQueryParameter("products["+i+"][unit]", cartList.get(i).get((Const.TAG_UNIT)));
   builder.appendQueryParameter("products["+i+"][unitPrice]", cartList.get(i).get((Const.TAG_RETAIL_PRICE)));

}

String myUrl = builder.build().toString();