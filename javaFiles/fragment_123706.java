List<Customer> customers = this.jdbcTemplate.query(
            "select first_name,status,customer_id from customer inner join v_customer_chat on customer.customer_id=v_customer_chat.sender_id inner join v_customer_chat_detail on v_customer_chat.chat_detail_id = v_customer_chat_detail.chat_detail_id where v_customer_chat_detail.is_read = ? and customer.status = ?;",new Object[] {true, true},
            new RowMapper<Customer>() {
                public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Customer customer = new Customer();
                    customer.setFirstName(rs.getString("first_name"));
                    customer.setStatus(rs.getBoolean("status"));
                    customer.setCustomerId(rs.getLong("customer_id"));
                    return customer;
                }
            });