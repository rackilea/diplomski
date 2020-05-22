NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());    
Double share = nf.parse(shareRow.get("share")).doubleValue();

sql = ("INSERT INTO `SHARE_VALUES` (`ID`, `SHARE`)" +
       "VALUES (NULL, ?);");
try
{
    // Create a Preparedstatement
    PreparedStatement ps;
    ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    ps.setDouble(1, share);
    ps.execute();
    ResultSet generatedKeys = ps.getGeneratedKeys();

}
catch (SQLException ex)
{
    java.util.logging.Logger.getLogger(Shares.class
            .getName()).log(Level.SEVERE, null, ex);

    return -1;
}