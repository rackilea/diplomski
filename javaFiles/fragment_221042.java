int i = 0;
while (i < s.length() && s.charAt(i) == 'X') {
  ++i;
}
if (i < s.length()) {
  if (s.charAt(i) != 'Y') {
    return false;
  }
  while (i < s.length() && s.charAt(i) == 'Y') {
    ++i;
  }
}
return i == s.length();