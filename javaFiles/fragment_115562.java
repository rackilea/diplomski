Matcher dateMatcher = Pattern.compile("\\d+\\/\\d+\\/\\d+").matcher("");

Document doc = ...
Elements tdElements = doc.select(...);

for(Element td : tdElements) {
    if (dateMatcher.reset(td.ownText()).matches()) {
        sb.append("1");
    }
}