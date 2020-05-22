String string = " java is a programing language .java is robust and powerful and it is also platform independent. ";

String subS1 = "programing language";
subS1 = subS1.replace(" ", "\\s+");
Pattern p1 = Pattern.compile(subS1);
Matcher match1 = string.matcher(subS1);

String subS2 = "platform independent";
subS2 = subS2.replace(" ", "\\s+");
Pattern p2 = Pattern.compile(subS2);
Matcher match2 = string.matcher(subS2);

String subS3 = "robust and powerful";
subS3 = subS3.replace(" ", "\\s+");
Pattern p3 = Pattern.compile(subS3);
Matcher match3 = string.matcher(subS3);

if (match1.find() && match2.find() && match3.find()) {
  // Whatever you like
}