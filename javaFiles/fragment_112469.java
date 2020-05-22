while(rs.next()) {
    result = new String[2];
    result[0] = rs.getString(2);
    result[1] = rs.getString(3);
    fetched.add(result);
}