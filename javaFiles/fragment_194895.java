public static byte[] bCrypt (String passPlain) {
    return BCrypt.hashpw(passPlain, BCrypt.gensalt(10)).getBytes();
}

// here is how you generate the hash
byte[] hashed = bCrypt(userpass).toBytes();

// here is how you authenticate a login
String password; // from the UI
String sql = "SELECT passHash FROM user WHERE username = ?";
pst = connect.prepareStatement(sql);
pst.setString(1, username);
rs = pst.executeQuery();

if (rs.next()) {
    byte[] hash = rs.getBytes(1);
    if (isMatch(password, new String(hash))) {
        // authenticate
    }
}