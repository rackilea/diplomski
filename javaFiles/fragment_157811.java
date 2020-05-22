rs = st.executeQuery(sql);
StringBuilder str = new StringBuilder();
while(rs.next()){

    //Retrieve by column name

    str.append("ID: " + rs.getInt("id"));
    str.append(", Trailer: " + rs.getString("Trailer"));
    str.append(", Block: " + rs.getString("Block"));
    str.append(", Location: " + rs.getString("Location"));
    str.append(", Date: " + rs.getString("Day"));
    str.append(", Comment: " + rs.getString("Comment"));

    //new line
    str.append("\n");
}

JOptionPane.showMessageDialog(null,str.toString());