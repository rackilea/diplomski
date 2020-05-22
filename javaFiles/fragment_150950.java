PreparedStatement st = null;
try {
  st = con.prepareCall( "IF EXISTS (SELECT * FROM tblPay@RetailStores ...
                  + "SET RetailID = :RetailID ,"
                  + "1)"); 
  for (StoreFile item : storeListToInsert) {
    st.setString(":RetailID", item.getRetailID());
    st.executeUpdate();   
  }
} finally {
  if (null != st) {st.close();}
}