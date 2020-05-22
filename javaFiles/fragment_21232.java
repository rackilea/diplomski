public static boolean checkMe(String s) {
    boolean amIValid = false;
      try {
       Integer.parseInt(s);
    // s is a valid integer!
    amIValid = true;
    } catch (NumberFormatException e) {
    //not an integer but you could continue with the rest numbers
    }
    return invalid;
    }