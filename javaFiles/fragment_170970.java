String s = "12345";
int cur = Integer.valueOf(s.charAt(0)); //49
cur = (int)s.charAt(0); //49
cur = Character.getNumericValue(s.charAt(0)); //1
cur = Integer.parseInt(String.valueOf(s.charAt(0))); //1
cur = Character.digit(s.charAt(0), 10); //1
cur = s.charAt(0) - '0'; //1