String regex = "(?:\\bprofiles\\s*\\{|(?<!^)\\G)[^{]+?(\\b\\w+\\b)\\s*\\{[^}]*}";

Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(output);

List<String> itemList = new ArrayList<>();
while(matcher.find()) {
    itemList.add(matcher.group(1));
}