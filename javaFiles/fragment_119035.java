PreparedStatement stmt = con.prepareStatement(
    "INSERT INTO tblcustomer (Cust_FirstName, Cust_LastName, Cust_Address, Cust_PhoneNumber, Cust_SSN, Cust_Email, Cust_Username, Cust_Password)"
    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

stmt.setString(1, strFname);
stmt.setString(2, strLname);
stmt.setString(3, strAddress);
stmt.setString(4, strPhone);
stmt.setString(5, strSSN);
stmt.setString(6, strEmail);
stmt.setString(7, strUserName);
stmt.setString(8, strPassword);