while (true) {
  pass = getStrSys();
  if (pass.length() < 7) {
    System.out.println("must be at least 7 characters long");
  } else {
    boolean upper = false;
    boolean lower = false;
    boolean number = false;
    for (char c : pass.toCharArray()) {
      if (Character.isUpperCase(c)) {
        upper = true;
      } else if (Character.isLowerCase(c)) {
        lower = true;
      } else if (Character.isDigit(c)) {
        number = true;
      }
    }
    if (!upper) {
      System.out.println("must contain at least one uppercase character");
    } else if (!lower) {
      System.out.println("must contain at least one lowercase character");
    } else if (!number) {
      System.out.println("must contain at least one number");
    } else {
      break;
    }
  }
}