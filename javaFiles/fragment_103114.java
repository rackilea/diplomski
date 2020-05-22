class SalesOrder {
    String id;
    String managerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

}

public void saveOrUpdate(List<SalesOrder> orders, String managerId) {
    String example_query = "insert into table(id, managerID,col2) values (?,?,?) on duplicate key update managerID= ? , col2 =?";
    final int batchSize = 500;

    for (int j = 0; j < orders.size(); j += batchSize) {
        final List<SalesOrder> pickedOrders = orders.subList(j,
                j + batchSize > orders.size() ? orders.size() : j + batchSize);
        getJdbcTemplate().batchUpdate(example_query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                SalesOrder order = pickedOrders.get(i);
                ps.setString(1, order.getId());
                ps.setString(2, order.getManagerId());
                // so on
            }
            @Override
            public int getBatchSize() {
                return pickedOrders.size();
            }
        });

    }

}