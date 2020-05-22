PreparedStatement ps = conex.getConnection().prepareStatement(
    "INSERT INTO abas001 (abas_cod, abas_cnt, abas_vol, abas_und) VALUES (?,?,?,?)");
try {
    ps.setObject(1, miAbasto.getAbas_cod());
    ps.setObject(2, miAbasto.getAbas_cnt());
    ps.setObject(3, miAbasto.getAbas_vol());
    ps.setObject(4, miAbasto.getAbas_und());
    int rowsInserted = ps.executeUpdate();
} . . .
finally {
    ps.close();
}