String q= "INSERT INTO data_table (id) values (?)";
Connection connection = new getConnection();
PreparedStatement ps = connection.prepareStatement(q);

for (Data d: data) {     
    ps.setString(1, d.getId());
    ps.addBatch();
}

ps.executeBatch();
ps.close();
connection.close();