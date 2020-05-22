String ss = "header\r\n--------------------------------------\r\n<b>12^Type:Table\r\n<b>12^ Table Number: 3\r\n-------------------------------- ------\r\n";
StringBuilder str = new StringBuilder();

String tokens[]=data.split("\r\n");
String regex = "\\<b>(\\d*)\\^";
Pattern pattern = Pattern.compile(regex);
for (String token : tokens) {

    Matcher matcher = pattern.matcher(token);
    if (matcher.find()) {
        String s1 = token.replace(matcher.group(0), "").trim();
        String number = matcher.group(1); // This is the number you want.
        // Do what you need with the value...
        str.append(s1);
        str.append("\n");
    } else {
        str.append(token).trimToSize();
        str.append("\n");
    }
}