String str = "@tag some text goes here and @tag nobody @tag should care about it @tag";
String tag = "@tag";
int start = str.indexOf(tag);
int end = str.lastIndexOf(tag);
if (start >= 0 && end > start) {
    String res = str
        .substring(start, end)
        .replaceAll(Pattern.quote(tag)+"\\s*", "")
        .trim();
    System.out.println("Result: '"+res+"'");
} else {
    System.out.println("Tag not found.");
}