PreparedStatement ps = (PreparedStatement) con.prepareStatement
                       (“SELECT username, password FROM users WHERE
                            state LIKE ? AND gender LIKE ?″); // AND ...



for(int i=0; i<n; i++) // n number of combo boxes
   if (!isSelected[i])
      ps.setString(i+1,"%");
    else
      ps.setString(i+1,content[i]);
 ResultSet rs=ps.executeQuery();