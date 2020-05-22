PreparedStatement masterStatement = masterConnection.prepareStatement("...");
PreparedStatement detailStatement = detailConnection.prepareStatement("SELECT ... WHERE something = ?");


ResultSet masterResults = masterStatement.executeQuery();
while (masterResults.next()) {
    detailStatement.setInt(1, ...);

    ResultSet detailResults = detailStatement.executeQuery();
    try {
        while (detailResults.next()) {
        }
    } finally {
        detailResults.close();
    }
}