public Map<Integer, List<Product>> getProductsByIndex (List<Product> products){
    Map<Integer, List<Product>> resultMap = new HashMap<>();

    for(Product product: products){
        List<Product> productsByCode = resultMap.get(product.getCode());
        if (productsByCode == null) {
           productByCode = new ArrayList();
           resultMap.put(product.getCode(), productByCode);
        }
        productsByCode.add(product);    
    }
    return resultMap;
}