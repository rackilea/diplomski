int scale = 2;
String s = "abc", ss = "";
for (char c : s.toCharArray()) { 
  for (int i = 0; i < scale; i++) {
    ss += c;
  }
}
System.out.println(ss); //ss = aabbcc