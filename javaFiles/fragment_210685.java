String tag = "strong";
String str = "This is <strong>Foo</strong>Bar.";

String regex = "<\\s*" + tag + "[^>]*>[^<]*</\\s*" + tag + "\\s*>";

System.out.println(str.replaceAll(regex, "")); // This is Bar.