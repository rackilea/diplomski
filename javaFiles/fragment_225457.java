ResultSet rs = stmt.executeQuery("select * from book");

printAll(rs); // Prints everything including foo

// deletes foo
while (rs.next()) {
    String title = rs.getString(2);
    if (title.equalsIgnoreCase("foo")) {
        rs.deleteRow();
    }
}

printAll(rs); // Prints everything without foo. Makes no sense.