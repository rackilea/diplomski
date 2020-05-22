// lastname, descending
(p1, p2) -> p2.getLastName().toUpper().compareTo(p1.getLastName().toUpper());
//          ^ here is now p2           ^ here is now p1

// firstname, descending
(p1, p2) -> p2.getFirstName().toUpper().compareTo(p1.getFirstName().toUpper());
//          ^ here is now p2            ^ here is now p1