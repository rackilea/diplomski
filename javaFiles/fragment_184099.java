Collection<Customer> data = new ArrayList<Customer>();

while (rs != null && rs.next()) {   
    Customer a = new Customer();
    a.setCustId(rs.getLong("CUST_ID"));
    a.setPerNo(period);
    a.setName(rs.getString("cust_nm"));

    data.add(a);
}