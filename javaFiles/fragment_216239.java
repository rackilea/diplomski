Pattern pattern = Pattern.compile("^AA(\\d+)");
Matcher matcher = pattern.matcher(code);

String id = null;

if (matcher.find()) {
    id = matcher.group(1);
}