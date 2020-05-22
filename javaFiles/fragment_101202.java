Statement stmt = conn.createStatement();
Statement updStmt = conn.createStatement();
ResultSet rsl = stmt.executeQuery("SELECT * FROM keranjang WHERE pemesan='"+login.userid+"'");

while (rsl.next()) {
    String nb = rsl.getString("nama_barang");
    String dtl = rsl.getString("detail");
    String beratt = rsl.getString("berat");
    String hrga = rsl.getString("harga");
    String jmlh = rsl.getString("jumlah");

    updStmt.executeUpdate("UPDATE barang SET stok=stok+'"+jmlh+"' WHERE nama_barang='"+nb+"' AND detail='"+dtl+"' AND berat='"+beratt+"'");
    updStmt.executeUpdate("DELETE FROM keranjang WHERE pemesan ='"+login.userid+"' AND nama_barang='"+nb+"'");
}