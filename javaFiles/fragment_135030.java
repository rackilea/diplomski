String regex = "\\{\\{code}}.*?\\{\\{/code}}|(\\{\\{html.*?}})";
Matcher m = Pattern.compile(regex, Pattern.DOTALL).matcher(str);
List<String> matches = new ArrayList<>();
while (m.find()) {
    String match = m.group(1);
    if (match != null) {
        matches.add(match);
    }
}