public List<Customer> select() {
    List<Customer> data = new ArrayList<Customer>(); // Here you define it
    // some code
        while (rs.next()) {
            data.add(new Customer(rs.getString("fname"), (s.getString("lname")));
        }
    // etc.
    return data;
}