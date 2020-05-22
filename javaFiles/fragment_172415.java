public static void saveCall(Call call) {
    conn = getInstance();

    if (conn != null) {
        calendar.setTime(call.getDate());
        String sql = "INSERT INTO Calls(id, datetime, duration, customer_phone_id, partner_phone_id) "
                    + "VALUES(null, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {                
            preparedStatement.setString(1, dateFormat.format(calendar.getTime()));
            preparedStatement.setLong(2, call.getDuration());
            preparedStatement.setLong(3, call.getPhone().getPhoneNumber());
            preparedStatement.setLong(4, call.getPhonePartner()
                    .getPhoneNumber());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}