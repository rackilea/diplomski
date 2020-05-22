public List<Customer> select(String cusDB) {
    return jdbcTemplate.query(
            "SELECT id, first_name, last_name FROM customers WHERE first_name= ?",
            new Object[] { cusDB },
            (rs, rowNum) -> new Customer(rs.getLong("id"),
                    rs.getString("first_name"), rs.getString("last_name")));
}