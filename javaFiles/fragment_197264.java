public int sumNumbers(String str) {
  int y = 0, z = 0, f4, f5 = 0;
  for (f4 = 0; f4 < str.length(); f4++) {
    if (Character.isDigit(str.charAt(f4))) {
      for (f5 = f4; f5 < str.length(); f5++) {
        if (!Character.isDigit(str.charAt(f5))) {
          z = (Integer.parseInt(str.substring(f4, f5)));
          y = y + z;
          f4 = f5;
          break;
        }
      }
      /* Handle Boundary Conditions */
      if (f4 != f5) {
          z = (Integer.parseInt(str.substring(f4, str.length())));
          y = y + z;
          break;
      }
    }
  }
  return y;
}