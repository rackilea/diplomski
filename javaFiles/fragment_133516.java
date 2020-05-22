StringBuilder s = new StringBuilder(x);
for (int a = 0; a < x.length(); a++) {
  char c = s.charAt(a);
  s.setCharAt(a, ' ');
  if (c == '@') {
    // Replace the spaces, etc, like above.
    x = s.toString().replaceAll("\\s+", "");
    return x;
  }
}
x = s.toString();
return x;