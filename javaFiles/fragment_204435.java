PreparedStatement preStmt = conn.prepareStatement(sql);
int count = 0;

for (String code : arguments) {
    preStmt.setString(++count, code);
}