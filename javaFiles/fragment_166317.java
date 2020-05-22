String text = "1234bbbbAAAAb2222 /*1231232132131221*/ [11] }";
Pattern pat = Pattern.compile("(\\d+)|([a-zA-Z]+)|(/\\*.*?\\*/)|([\\[\\]{}])");
Matcher m = pat.matcher(text);
while (m.find()) {
    if (m.group(1) != null)
        System.out.println("Number: " + m.group(1) );
    else if (m.group(2) != null)
        System.out.println("String: " + m.group(2) );
    else if (m.group(3) != null)
        System.out.println("Comment: " + m.group(3) );
    else if (m.group(4) != null)
        System.out.println("Symbol: " + m.group(4) );
}