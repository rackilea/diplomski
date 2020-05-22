String input = "(samebib(A, B, 4.0) :- author(A, UniqueVar1), author(B, UniqueVar1), !)";
Pattern p1 = Pattern.compile("\\((.*?)\\(");

Matcher m = p1.matcher(input);
if (m.find()) {
    System.out.println(m.group(1));
}