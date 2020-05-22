String input = "[ISOLATION GROUP X] blabla";
input += "[OTHER FLAG][ISOLATION GROUP Y] blabla";
String pattern = "\\[ISOLATION GROUP ([^\\]]+)";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(input);
while (m.find()) {
    System.out.println("Found value: " + m.group(1));
}

Found value: X
Found value: Y