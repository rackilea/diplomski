String input = "£50,000 - £55,000";
Pattern regex = Pattern.compile("\\d[\\d,\\.]+");
Matcher finder = regex.matcher(input);
if( finder.find() ) { // or while() if you want to process each
  try {
    double value = Double.parseDouble(finder.group(0).replaceAll(",", ""));
    // do something with value
  } catch (NumberFormatException e ) {
    // handle unparseable
  }
}