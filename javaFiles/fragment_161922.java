public String getCost() {
    String productValue = null;
    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Inventory");
    query.whereEqualTo("productName", "Capris");
    try {
        List<ParseObject> results = query.find();
        productValue = results.get(0).getString("productPrice");
        return productValue;
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return productValue;
}