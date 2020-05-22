try (PreparedStatement ps = conn.prepareStatement("insert into a(b, c) values (?, ?)") ) {
    while(var4.next()) {
        ps.setInt(1, rs.getInt("b"));
        ps.setInt(2, rs.getInt("c"));
        ps.executeUpdate();
    }
} catch( SQLException e){
    ...
}