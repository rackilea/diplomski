String[][] a = new String[10][2];
    PreparedStatement pst = con.prepareStatement("INSERT INTO sap_details VALUES (?,?)");
    for (int i = 0; i < 10; i++) {
        pst.setString(1, a[i][0]);
        pst.setString(2, a[i][1]);
        pst.addBatch();
    }
    int[] results = pst.executeBatch();