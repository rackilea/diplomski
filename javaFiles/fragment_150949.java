for (StoreFile item : storeListToInsert) {
            st = con.prepareCall( "IF EXISTS (SELECT * FROM tblPay@RetailStores ...
            + "'" + item.getTelNo() + "',"
            + "1)"); 
            st.executeUpdate();

}