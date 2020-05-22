while (myRs.next()) {
    // retrive data from result set row
    int placeNo = myStmt.getInt("NR_MIEJSCA");
    Date start = myStmt.getDate("START");
    Date end = myStmt.getDate("KONIEC");
    String userName = myStmt.getString("IMIE_NAZWISKO");
    int phone = myStmt.getInt("TELEFON");

    // create new temporary Book object
    Book tempBook = new Book(placeNo, start, end, userName, phone);

    // add it to our list of Books
    books.add(tempBook);
}