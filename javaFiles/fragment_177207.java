string updateText = "insert into bill_items (Item_code, Type, Brand_Name, Item_Name, Price) ";
updateText += "values (?, ?, ?, ?, ?)";

PreparedStatement stmt = con.prepareStatement(updateText);
stmt.setInt(1, icode);
stmt.setString(2, t);
stmt.setString(3, bname);
stmt.setString(4, iname);
stmt.setInt(5, p);

int a = stmt.executeUpdate();