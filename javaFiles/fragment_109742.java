ContentValues cv = new ContentValues();
cv.put("ProductName", product.getProductName());
cv.put("InStock", product.getProductInStock());
cv.put("CostPrice", product.getProductCostPrice());
cv.put("SellingPrice", product.getProductSellingPrice());
cv.put("Description", product.getProductDescription());
int result = db.update("Inventory", cv, "rowid = ?", new String[] {String.valueOf(Integer.parseInt(rowId) + 1)});