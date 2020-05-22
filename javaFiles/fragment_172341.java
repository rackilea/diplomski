if (rs.next()) {
    medicines_id.add(rs.getString("id"));
    medicines_price.add(rs.getDouble("sellprice"));
 } else {
    medicines_id.add(rs.getString("9999"));
    medicines_price.add(rs.getDouble("10.00"));
 }