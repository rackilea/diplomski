String author = model.getValueAt(row, 0).toString();
String bookname = model.getValueAt(row, 1).toString();
String query = 
    "UPDATE Books SET availability = ? WHERE author = ? AND bookname = ?";
try {
    ps = dbConnect.getConnection().prepareStatement(query);
    ps.setString(1, notavail);
    ps.setString(2, author);
    ps.setString(3, bookname);
    ...