for(int i = 0; i <storeListToInsert.size();i++){
  StoreFile item = storeListToInsert.get(i);
        st = con.prepareCall( "IF EXISTS (SELECT * FROM tblPay@RetailStores ...
        + "'" + item.getTelNo() + "',"
        + "1)"); 
        st.executeUpdate();

       }