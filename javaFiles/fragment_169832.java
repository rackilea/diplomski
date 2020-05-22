JsonObject productDetail = new JsonObject();
productDetail.addProperty("productId", productId);
productDetail.addProperty("qty", qty);

JsonArray array = new JsonArray();
array.add(productDetail);