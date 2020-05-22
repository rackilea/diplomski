try {
    Connection conn = pool.getConnection();
    String sql = ("UPDATE company SET Email = ?, Password = ? WHERE ID = ?");
    PreparedStatement p = conn.prepareStatement(sql);
    p.setString(1, c.getEmail());
    p.setString(2, c.getPassword());
    p.setLong(3, id);
    int i = p.executeUpdate();
    conn.commit();      // <-- MAKE SURE TO COMMIT THE TRANSACTION TO THE DATABASE!!!
    System.out.println("changes: " + i);
    pool.releaseConnection(conn);
} catch(Exception e) {
    // handle errors here
} finally {
    try { if (p != null) p.close(); } catch (Exception e) {};
    try { if (conn != null) pool.releaseConnection(conn); } catch (Exception e) {};
}