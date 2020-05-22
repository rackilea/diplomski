rs = ps.executeQuery();
if (rs.next()) {
    UserPass up = new UserPass();
    up.setUserName(rs.getString("user_name"));
    return up;
} else {
    return null;
}