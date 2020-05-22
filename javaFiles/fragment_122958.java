String sql = "insert into bill_room(DischargeID, BillingDate, "
        + "RoomCharges, ServiceCharges, PaymentMode, PaymentModeDetails, "
        + "ChargesPaid, DueCharges, TotalCharges, NoOfDays, TotalRoomCharges) "
        + "values(?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?)";

try (PreparedStatement insert = connection.prepareStatement(sql)) {

    insert.setInt(1, txtDischargeID.getText());
    insert.setString(2, txtBillingDate.getText());

    //...Set the the right type if int use setInt if string use setString ...

    insert.setDouble(11, Double.parseDouble(txtTotalRoomCharges.getText()));

    insert.executeUpdate();
}