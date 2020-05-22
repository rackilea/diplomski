DefaultPieDataset pieDataSet = new DefaultPieDataset();

// select subject,value from datatable;
// rs will be your ResultSet

    while (rs.next()) {
        String sub = rs.getString(1);
        int val = rs.getInt(2);
        pieDataSet.setValue(sub, new Integer(val));
    }