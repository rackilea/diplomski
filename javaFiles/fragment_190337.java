products.forEach(p -> {
    ProductWebElement productElement = productElements.stream().filter(
        pe -> pe.getProductCode().equals(p.getCode())
    ).findAny().orElseThrow(() -> new AssertionError("Product: " + p.getCode() + " not found!"));
    Assert.assertEquals(p.getQuantity(), productElement.getQuantity());
});