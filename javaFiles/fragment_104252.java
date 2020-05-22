String text = "This is awesome Wait what? [[Foo:f1]] [[Foo:f2]]"
        + " [[Foo:f3]] Some texty text [[Foo:f4]]";

String field = "Foo";

Matcher m = Pattern.compile(
        "\\[\\[" + field + ":\\s*([\\w\\s]+?)\\s*\\]\\]").matcher(text);

while (m.find())
    System.out.println(m.group(1));