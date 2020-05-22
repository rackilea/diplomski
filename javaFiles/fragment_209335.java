ConnectionPool pool=ConnectionPool.getInstance();

Connection con=pool.getConnection();

PreparedStatement prep=null;
try{

  prep=con.prepareStatement(sqlUpdate);

  prep.setInt(1,toegewezenAan);

  prep.setDouble(2, verkoopPrijs);

  prep.setDouble(3,totaalAfgetrokken);

  prep.setString(4, "VERKOCHT");

  prep.setInt(5, artikelId);

  prep.executeUpdate();

} catch(SQLException e){

  e.printStackTrace();
} finally
{

  pool.freeConnection(con);
}