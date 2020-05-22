String queryx = "Select CusType_ID, CusTypeName from CustomerType";

    ResultSet rs = c.createStatement().executeQuery(queryx);

    while (rs.next()) {
        int recordNumber = 1;
        int recNumber =2;

        String sx = rs.getString("CusTypeName");
        String customerID = rs.getString("CusType_ID");


        typeBox.addItem(new MyObject(customerID, sx));


        }