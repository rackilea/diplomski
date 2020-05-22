getDaysForMonth() {
  if (month == 1) { // January
    return 31;
  }
  else if (month == 2) { // February
    // special case, will have to do some more complex checks here :)
    // you may already have these conditions in your question body
    if (/* year is a leap year */) {
      return 29;
    }
    else {
      return 28;
    }
  }
  // and so on ...
}