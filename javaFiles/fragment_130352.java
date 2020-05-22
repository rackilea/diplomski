for (Product product : products) {
    String json = objectMapper.writeValueAsString(product);
    // handle the exception as well above
    createDocument(ElasticSearchConstants.PRODUCTS_INDEX,
            ElasticSearchConstants.PRODUCTS_DOCUMENT_TYPE,
            json, product.getPartNo());
}