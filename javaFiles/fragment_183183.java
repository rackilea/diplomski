try {
    ps = connection.prepareStatement("select " + sequence + " from dual");
    rs = ps.executeQuery();
    if (rs.next()) {
        value = rs.getInt(1);
    }
    System.out.println("Next payment Id: " + value);
} catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} finally {
    Util.close(connection, rs, ps);
}