String input = "/*\n  /// Content goes here ///\n*/ stuff stuff /* More Content */";
String pattern = "/\\*(.*?)\\*/";

Pattern r = Pattern.compile(pattern, Pattern.DOTALL);

Matcher m = r.matcher(input);
while (m.find()) {
   System.out.println("Found content:\n " + m.group(1));
}