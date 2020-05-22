Connection con = null;
PreparedStatement pStmt = null;
ResultSet rs = null;
try
{
    con = ds.getConnection();
    pStmt = con.prepareStatement("SELECT ....");
    rs = pStmt.executeQuery();
    while (rs.next()) {
        Item item = new Item();

        item.setItemNo(rs.getString("item_id"));
        ...

        items.add(item);
    }
}
finally {
    rs = DBUtil.close (rs);
    pStmt = DBUtil.close (rs);
    con = DBUtil.close (rs);
}