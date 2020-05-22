Object serialNumber = obj.get("SrNo");
Object brand = obj.get("Brand");
Object productName = obj.get("Product Name");
Object price = obj.get("Price");

model.addRow( new Object[] {serialNumber, brand, productName, price} );