advance() {
  int lastDayThisMonth = getDaysForMonth();

  if (day == lastDayThisMonth) {
    // reset day to 1
    // increase month (also have to know whether it's the last month and reset it accordingly)
    // (hint: modulo operator % is your friend)
    // possibly increase year (if month gets reset to 1 too)
  }
  else {
    // increment day
  }
}