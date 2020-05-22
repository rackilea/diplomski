public boolean validateTime(String timeForValidation, String format) {
    if(isThisValid(timeForValidation, format) == true) {
      return true;
    }
    throw new IllegalArgumentException(...);
}

public boolean validateDate(String dateForValidation, String format) {
    if(isThisValid(dateForValidation, format) == true) {
      return true;
    }
    throw new IllegalArgumentException(...);
}

private boolean isThisValid(String timeToFormat, String timeFormat){
  // ...
}