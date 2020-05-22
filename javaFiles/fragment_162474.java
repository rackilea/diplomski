if(date1 == null ) {
  if (date2 == null) {
    return 0;
  } else {
    return /*either -1 or 1 depending on where nulls should end up*/
  }
} else {
  if (date2 == null) {
    return /*either 1 or -1 depending on where nulls should end up*/
  } else {
    return date1.compareTo(date2); //this assumes successful parsing, I'll leave those details for you
  }
}