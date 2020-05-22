Class.forname ...
Connection con = ...
String sql = "INSERT INTO user (`FirstName`, `LastName`, `Phone Number`, `Email`, `Password`) VALUES (?, ?, ?, ?, ?)";

String fname = txtname.getText();
String lname = txtLname.getText();

/* etc.. */

PreparedStatement prep = con.prepareStatement(sql);
prep.setString(1,fname);
prep.setString(2,lname);

prep.excuteUpdate();