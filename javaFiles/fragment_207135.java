public final Connection CONNECTION;

public void sqlAddData(Algorithm codec, String input, String translated) throws SQLException {

    CONNECTION = DriverManager.getConnection(url, login, pass);

    try (CONNECTION) {

        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        String add = " insert into db.public.history ( codec, input, translated, date)  values(?,?,?,?)";
        PreparedStatement prepared = CONNECTION.prepareStatement(add);
        prepared.setString(1, String.valueOf(codec));
        prepared.setString(2, input);
        prepared.setString(3, translated);
        prepared.setTimestamp(4, date);
        prepared.executeUpdate();

    } catch (SQLException e) {

        // Handle your exception correctly or throw it.

    }
}