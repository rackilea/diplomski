private void mergePropertiesToOffer(InsuranceDocumentsSession insuranceSession) {
    Validate.notNull(insuranceSession, "insurance session can't be null");
    if (insuranceSession.getOffer() == null) return;
    Map<String, InsuranceProductDto> offerProductMap = insuranceSession.getOffer().getProducts()
            .stream()
            .filter(this::validateOfferProduct)
            .collect(Collectors.toMap(InsuranceProductDto::getObjectName, Function.identity())); // assuming 'objectName' to be unique

    Map<String, InsuranceProductDto> documentsProductMap = insuranceSession.getDocuments()
            .stream()
            .filter(Objects::nonNull)
            .flatMap(d -> d.getProducts().stream())
            .filter(this::validateDocumentProduct)
            .collect(Collectors.toMap(InsuranceProductDto::getObjectName, Function.identity())); // assuming 'objectName' to be unique

    Map<String, Product> productsToProcess = new HashMap<>(documentsProductMap);
    productsToProcess.forEach((k, v) -> {
        if (offerProductMap.containsKey(k)) {
            offerProductMap.compute(k, (s, product) -> {
                Objects.requireNonNull(product).setProperties(v.getProperties());
                return product;
            });
        }
    });

    // now the values of 'offerProductMap' is what you can set as an updated product list under offer
}


private boolean validateDocumentProduct(InsuranceProductDto product) {
    return Objects.nonNull(product)
            && MapUtils.isNotEmpty(product.getProperties())
            && StringUtils.isNotEmpty(product.getObjectName());
}

private boolean validateOfferProduct(InsuranceProductDto offerProduct) {
    return Objects.nonNull(offerProduct)
            && MapUtils.isEmpty(offerProduct.getProperties())
            && StringUtils.isNotEmpty(offerProduct.getObjectName());
}