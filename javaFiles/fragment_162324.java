int count = 0;

while (rs.next()) {
    ++count;
    // Get data from the current row and use it
}

if (count == 0) {
    System.out.println("No records found");
}