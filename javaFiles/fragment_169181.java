public String block(String s, char c){
    if (s.length() == 0)
      return "";
    if (s.charAt(0) == ' ')
        return " " + block(s.substring(1), c);
     return c + block(s.substring(1), c);
}