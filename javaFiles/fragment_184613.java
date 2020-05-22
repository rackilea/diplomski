NodeList products = (NodeList) path.evaluate("/inventory/products/product", doc, XPathConstants.NODESET);

for (int i = 0; i <  products.getLength(); i++) {
    Node product = products.item(i);
    String code = path.evaluate("code", product);
    String description = path.evaluate("desc", product);
    Double price = (Double) path.evaluate("price", product, XPathConstants.NUMBER);
    Double quantity = (Double) path.evaluate("quantity", product, XPathConstants.NUMBER);

    Product p = new Product(code, description, price, quantity.intValue());
}