// Java style variable names.
String date1 = jTextField.getText();
String date2 = jTextField2.getText();

// using CDate...
pre=conn.prepareStatement("select * from Table where Date "
    + "between CDate(?) and CDate(?) order by Date");
pre.setString(1, date1); // bind param 1
pre.setString(2, date2); // bind param 2

ResultSet rs=pre.executeQuery();