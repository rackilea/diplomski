Pattern pattern = Pattern.compile("ParseGeoPoint\\[([\\d.-]+),([\\d.-]+)]");
Matcher matcher = pattern.matcher(myText);
if (matcher.matches()) {
    lat = Double.parseDouble(matcher.group(1));
    lang = Double.parseDouble(matcher.group(2));
}