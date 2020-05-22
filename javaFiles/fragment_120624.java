Pattern p = Pattern.compile("[^/]*/([^/]*)/.*");
  Matcher m = p.matcher("foo/bar/input");
  if (m.find()) {
     String captured = m.group(1); // This equals "bar"
     String matched = m.group(0); // This equals "foo/bar/input"
  }