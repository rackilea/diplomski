public void updateStockBatch(List<Product> allProducts, int addQuantity, int noOfUnits) {
    String sql = "UPDATE products SET UNITS_IN_STOCK = ? WHERE ID = ?";
    List<Product> productsToUpdate = 
        allProducts.stream()
                   .filter(p -> p.getUnitsInStock() < noOfUnits)
                   .collect(Collectors.toList());
    if (!productsToUpdate.isEmpty()) {

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public int getBatchSize() {
                return productsToUpdate.size();
            }

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {

                Product product : productsToUpdate.get(i);
                ps.setLong(1, product.getUnitsInStock() + addQuantity);
                ps.setString(2, product.getProductId());
            }
        });
    }
}