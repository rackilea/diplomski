for(int i = 0; i <storeListToInsert.size();i++){
        st = con.prepareCall( "IF EXISTS (SELECT * FROM tblPay@RetailStores ...
        + "'" + storeListToInsert.get(i).getTelNo() + "',"
        + "1)"); 
        st.executeUpdate();

       }