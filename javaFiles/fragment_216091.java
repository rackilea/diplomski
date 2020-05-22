Map<String, String> replacementsMap = Map.ofEntries(
        Map.entry("1", "N"),
        Map.entry("N", "1")
);

String input = "10N10N";
Pattern p = Pattern.compile("1|N");
Matcher m = p.matcher(input);
String replaced = m.replaceAll(match -> replacementsMap.get(match.group()));
System.out.println(replaced);