Map<Integer, MyRow> map = new HashMap<Integer, MyRow>(0);
ResultSet rs;
// get your result set from some db query or whatever
while(rs.next()) {
    MyRow mr = new MyRow(rs.getString(yourCol1Index), rs.getInt(yourCol2Index), ...);
    map.put(rs.getInt(yourKeyColumnIndex), mr);
}
// finaly release the resources
rs.close();