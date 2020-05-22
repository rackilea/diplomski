while (myRs.next()) {
    // retrive data from result set row
    int placeNo = myRs.getInt("NR_MIEJSCA");
    Date start = myRs.getDate("START");
    Date end = myRs.getDate("KONIEC");
    String userName = myRs.getString("IMIE_NAZWISKO");
    int phone = myRs.getInt("TELEFON");

    // create new temporary Book object
    Book tempBook = new Book(placeNo, start, end, userName, phone);

    // add it to our list of Books
    books.add(tempBook);
}