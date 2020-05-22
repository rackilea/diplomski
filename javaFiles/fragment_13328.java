public class ConCurrencySdo {
  public String ConnectionString,RuntimeUser,RuntimePassword;
  public Connection con;
  public ResultSet GetBase;

  public void CreateRecordset() throws Exception {
    con = Drivermanager.getConnection(ConnectionString,RuntimeUser,RuntimePassword);
    PreparedStatement cmdTemp = con.prepareStatement("SELECT BLMBG_CURR_CODE,BLMBG_CURR_NAME" 
      + " FROM AON_CURRENCY_SDO" + " ORDER BY BLMBG_CURR_NAME");
    GetBase = cmdTemp.executeQuery();
  }
}