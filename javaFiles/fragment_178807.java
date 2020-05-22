try (Connection connection = **strong text**DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password")) {

try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO PUBLISHER (CODE, PUBLISHER_NAME) VALUES (?, ?)")) {
    stmt.setString(1, book.getPublisher().getCode());   
    stmt.setString(2, book.getPublisher().getName());           
    stmt.executeUpdate();
}
// stmt is auto closed here, even if SQLException is thrown

try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO BOOK (ISBN, BOOK_NAME, PUBLISHER_CODE) VALUES (?, ?, ?)");
    stmt.setString(1, book.getIsbn());  
    stmt.setString(2, book.getName());
    stmt.setString(3, book.getPublisher().getCode());
    stmt.executeUpdate();
}
// stmt is auto closed here, even if SQLException is thrown
}// connection is auto closed here, even if SQLException is thrown