String sql = "insert into role(name, code) values(?,?);" +
    "insert into person(first_name, last_name, description, role_id) values(?,?,?,(SELECT LAST_INSERT_ID()));";

int[] arr = template.batchUpdate(sql, new BatchPreparedStatementSetter() {

    @Override
    public void setValues(PreparedStatement ps, int i) throws SQLException {
        Role role = roles.get(i);
        Person person = list.get(i);
        ps.setObject(1, role.getName());
        ps.setObject(2, role.getCode();
        ps.setObject(3, person.getFirstName());
        ps.setObject(4, person.getLastName());
        ps.setObject(5, person.getDescription());
    }

    @Override
    public int getBatchSize() {
        return list.size()
    }
});