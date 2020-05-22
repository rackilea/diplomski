public OrderResultSetExtractor implement ResultSetExtractor<List<Order>> {
    public List<Order> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Order> orders = new ArrayList<Order>();
        Order current = null;
        while (rs.next()) {
            long orderId = rs.getLong(1);
            String itemName = rs.getString(2);
            long price = rs.getLong(3);
            if (current == null || current.getId() != orderId) {
                current = new Order();
                current.setId(orderId);
                orders.add(current);
            }
            current.getItems().add(new Item(itemName, price));
        }
        return orders;
    }
}