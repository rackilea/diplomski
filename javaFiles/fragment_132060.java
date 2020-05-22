String TEXT_IN_DBL_QUOTES_REGEX="\"([^\"]*)\"|(?<=,) *(?=,|$)";
String rowData="\"Field1\", \"Field2\", , \"Field4\", ";

List<String> fields = new ArrayList<>();
Pattern regex = Pattern.compile(TEXT_IN_DBL_QUOTES_REGEX);
Matcher matcher = regex.matcher(rowData);
while(matcher.find()) {
    fields.add(matcher.group(1));
}
System.out.println (fields);