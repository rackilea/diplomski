String [] queries = {
    "insert into employee (name, city, phone) values ('A', 'X', '123')",
    "insert into employee (name, city, phone) values ('B', 'Y', '234')",
    "insert into employee (name, city, phone) values ('C', 'Z', '345')",
};
Connection connection = new getConnection();
Statement statement = connection.createStatement();

for (String query : queries) {
    statement.addBatch(query);
}
statement.executeBatch();
statement.close();
connection.close();