public HashMap<String, BigDecimal> addProduct(String product, String price) {
    // This is the only change -------------------------------^^^^^^
    BigDecimal productPrice = new BigDecimal(price);
    productMap.put(product, productPrice);
    return productMap;
}