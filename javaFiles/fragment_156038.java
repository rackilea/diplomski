String cutText(String text) {
  int i = Math.min(200, text.length());
  while (i < text.length() && text.charAt(i) != ' ') {
    ++i;
  }
  return text.substring(0, i).replace('\n', ' ');
}