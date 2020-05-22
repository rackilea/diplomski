public void isSpace(String[] array) {
  for (int i=0; i<array.length; i++) {
    if( (array[i] == null) || (array[i].trim().length() == 0)) {
      //true on null, empty string, or white space only. Do something here
      array[i] = "add some thing here";
    }
    else {
      //not null, not empty string, or not white space. Do something here
    }
  }
}