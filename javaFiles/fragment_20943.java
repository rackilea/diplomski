String text = "Your text";
Pattern pattern = Pattern.compile("(<img .*?>)");
Matcher matcher = pattern.matcher(text);
if (matcher.find()) {
    // do something with matcher.group(1));
}