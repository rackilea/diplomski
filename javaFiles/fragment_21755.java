final Matcher m = Pattern.compile("[ABCD]").matcher("aoeuaAaoe");
if (m.find())
  switch (m.group().charAt(0)) {
  case 'A': break;
  case 'B': break;
  }