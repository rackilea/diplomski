boolean isLink(String s) {
  try {
     new URL(s);
     return true;
  } catch (MalformedURLException e) {
     return false;
  }
}