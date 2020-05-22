int kind(String input) {
  if (input.matches("P[1-9]{2}") {
    return 0;
  } else if (input.matches("P0[0-9]")) {
    return 1;
  } else if (input.matches("S.*")) {
    return 2;
  } else if (input.matches("[1-9]{2}")) {
    return 3;
  } else {
    return 4;
  }
}