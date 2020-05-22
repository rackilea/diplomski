PreparedStatement ps = (PreparedStatement) con.prepareStatement
                   (“SELECT username, password FROM users WHERE (? OR
                        state=?) AND (? OR gender=?)″); // AND ...

for(int i=0; i<n; i++) {// n number of combo boxes
    ps.setString(2*i+1,content[i]);
    ps.setBoolean(2*i+2,isSelected[i]);
 }
 ResultSet rs=ps.executeQuery();