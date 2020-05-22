Pattern patt = Pattern.compile(pattern);
Matcher matcher = patt.matcher(s);
if (matcher.find()) {
    return matcher.group(); // you can get it from desired index as well
} else {
    return null;
}