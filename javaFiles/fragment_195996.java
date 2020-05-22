try {
        Statement stmt = DBController.connection.createStatement();
        String select = "SELECT ID FROM individuen WHERE Geschlecht is NULL ORDER BY RANDOM()" +
        " LIMIT " + Integer.toString(copyMaen);
        ResultSet rs = stmt.executeQuery(select);
        PreparedStatement ps = DBController.connection.prepareStatement("UPDATE individuen set Geschlecht  = ? WHERE ID = ?;");
        // rs.beforeFirst();
        int count = 0;
        while (rs.next()) {
            ps.setInt(1, 0);
            ps.setInt(2, rs.getInt(1));
            ps.addBatch();
            if (count%100==0) {
                System.out.println(count);
            }
            count++;
        }
        DBController.connection.setAutoCommit(false);
        ps.executeBatch();
        DBController.connection.setAutoCommit(true);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}