private class MyObjectExtractor implements ResultSetExtractor{

    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Long, Customer> map = new HashMap<Long, Customer>();

        while (rs.next()) {
            Long id = rs.getLong("CUSTOMER_ID");
            Customer customer = map.get(id);
            if(customer == null){
                customer = new Customer();
                customer.setId(id);
                customer.setName(rs.getString("CUSTOMER_NAME"));
                customer.setAccountNumber(rs.getLong("CUSTOMER_ACCOUNT_NO"));
                map.put(id, customer);
                    }

            int type = rs.getInt("IS_BRAND");
            if(type == 1) {
                List brandList = customer.getBrands();
                if(brandsList == null) {
                    brandsList = new ArrayList<Brand>();
                    customer.setBrands(brandsList);
                }
                Brand brand = new Brand();
                brand.setId(rs.getLong("COL_A"));
                brand.setName(rs.getString("COL_B"));
                brandsList.add(brand);
            } else if(type == 0) {
                List ordersList = customer.getOrders();
                if(ordersList == null) {
                    ordersList = new ArrayList<Order>();
                    customer.setOrders(ordersList);
                }
                Order order = new Order();
                order.setId(rs.getLong("COL_A"));
                ordersList.add(order);
            }
        }
        return new ArrayList<Customer>(map.values());
    }
}