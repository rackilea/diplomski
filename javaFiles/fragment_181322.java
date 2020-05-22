String regex = "[0-9]{5,7}[a-z][a-z0-9_]*|-?\\d*\\.\\d+(?![-+0-9.])";
String string = "142d  000781fe0000326f BPD    false    65535 FSK_75     FSK_75     -51.984   -48";

Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
Matcher matcher = pattern.matcher(string);

String result = "";

while (matcher.find()) {            
    result += matcher.group(0);
}

System.out.println(result); // 000781fe0000326f-51.984