Pattern p3DigitsGap = Pattern.compile(".*\\b(\\d\\s\\d{2})\\b.*");
Matcher matcher = p3DigitsGap.matcher(myString1);
if (matcher.find()) {
   Log.i("Matcher is true");
   String extract = matcher.group(1);
   Log.d("extract: " + extract);
}