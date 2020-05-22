while (rs.next()) {
// ResultSet columns: 1 = UserName 2 = FirstName 3 = LastName  4 = Organization
            userInfo[0] = rs.getString(1); // assign UserName result to variable
            userInfo[1] = rs.getString(2); // assign First_Name result to variable
            userInfo[2] = rs.getString(3); // assign Last_Name result to variable
            userInfo[3] = rs.getString(4); // assign Organization result to variable
}