public String epwd(String pwd) {
  pwd = pwd.toUpperCase();
  String epwd = "";
  int i;
  for (i=0; i < pwd.length(); i++) {
    epwd = epwd + ((char)(pwd.charAt(i) + 7));
  }
  return epwd;
}