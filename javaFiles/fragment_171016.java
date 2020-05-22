DatabaseRecords SaveSale = new DatabaseRecords();
    try {
        SaveSale.SaveSale(null, null, null, null, null, null, null, null, null, null, null, null);
    } catch (ClassNotFoundException | SQLException ex) {
        System.out.println("Exception: " + ex);
    }