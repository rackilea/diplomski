String shortest = null;
Pattern pattern = Pattern.compile("(?=(d.*?o.*?a))");
Matcher matcher = pattern.matcher("ondjswxaeqobdnoajezbpfrehanxi");
while (matcher.find()) {
for (int i = 1; i <= matcher.groupCount(); i++) {
    if (shortest == null || matcher.group(i).length() < shortest.length()) {
        shortest = matcher.group(i);
    }
}