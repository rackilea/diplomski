String s = "true && #{ab_true_cd} || 0";
StringBuffer result = new StringBuffer();
Matcher m = Pattern.compile("(#\\{[^{}]*})|\\btrue\\b").matcher(s);
while (m.find()) {
    if (m.group(1) != null) {
        m.appendReplacement(result, m.group(1)); // if a #{} block found, restore it
    }
    else {
        m.appendReplacement(result, "1"); // else, replace true with 1
    }
}
m.appendTail(result);
System.out.println(result.toString());