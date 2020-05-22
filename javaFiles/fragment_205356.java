String regExp = "(?i)([0-9]+(?:[.,][0-9]+)?)\\s*euro?";
Pattern pattern = Pattern.compile(regExp);
String input1 = "aerae aerjakaes jrj kajre kj 112123 aseraer 1.05 Eur aaa";
Matcher matcher = pattern.matcher(input1);
if (matcher.find()) {
    System.out.println(matcher.group(1));
}