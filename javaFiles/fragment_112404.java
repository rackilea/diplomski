try (Connection connection = getSQLConnection();
        PreparedStatement ps = connection.prepareStatement(qry);
        ResultSet rs = ps.executeQuery()) {

    // process result set here
}