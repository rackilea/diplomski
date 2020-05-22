String str1 = "_AnyString_";
int start_underscore = str1.indexOf("_");
int end_underscore = str1.indexOf("_", start_underscore + 1);
String str_anything = str1.substring(start_underscore + 1, end_underscore);
String str_replace_asterisk = str_anything.replaceAll(".", "*");
System.out.println(str_replace_asterisk);
str1 = str1.replace(str_anything, str_replace_asterisk);
System.out.println(str1);