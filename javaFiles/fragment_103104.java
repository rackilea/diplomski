public WarehouseItem(String warehouseItem) {
    String key, brand, model;
    int weightInKG;
    double price; 
    String[] tok = warehouseItem.split(",");
    if (tok.length != 5) {
        throw new IllegalStateException("Invalid CSV: not enough columns");
    }
    key = tok[0];
    brand = tok[1];
    model = tok[2];
    weightInKG = Integer.parseInt(tok[3]);
    price = Double.valueOf(tok[4]);
    // Do something with the values you've got
    ...
}