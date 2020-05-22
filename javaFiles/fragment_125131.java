BasicDBList productList = new BasicDBList();
 for (Product produto : wallet.getSimulation().getFutureProductList()) {
    BasicDBList discountList = new BasicDBList();
    for (Discount discount : produto.getDiscountList()) {
       discountList.add(new BasicDBObject("nameDiscount", discount.getNameDiscount()).append("percentage", discount.getPercentage()));
    }
    productList.add(new BasicDBObject("name", produto.getName()).append("minimum", produto.getMinimun()).append("discountList", discountList));
 }
 DBObject update = new BasicDBObject("$push", new BasicDBObject("simulatedProduct", productList));
 collection.update(document, update, true,true);