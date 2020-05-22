PreparedStatement stmt;
    try {
        stmt = con.prepareStatement("update BcHeader set Label = ? where memo like ?");
        for (Map.Entry<String, String> entry : list.entrySet()) {
        stmt.setString(1, entry.getKey());
        stmt.setTimestamp(2, new Timestamp(new Date().getTime()), Calendar.getInstance());
        stmt.setString(3, entry.getValue());
        stmt.executeUpdate();
    }
    } catch (SQLException e) {
        e.printStackTrace();
    }