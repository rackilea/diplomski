String s = "[style and tags info] valid text info [more style info] more info here[styles]";
StringBuffer result = new StringBuffer();
Matcher m = Pattern.compile("\\[[^\\]\\[]+]|\\b(info)\\b").matcher(s);
while (m.find()) {
    if (m.group(1) != null) {
        m.appendReplacement(result, "change");
    }
    else {
        m.appendReplacement(result, m.group());
    }
}
m.appendTail(result);
System.out.println(result.toString());
// => [style and tags info] valid text change [more style info] more change here[styles]