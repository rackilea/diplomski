if (!rs.next()) {                            //if rs.next() returns false
                                             //then there are no rows.
    System.out.println("No records found");

}
else {
    do {
        // Get data from the current row and use it
    } while (rs.next());
}