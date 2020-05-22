String line = "[NUM1]+[NUM2]";
Pattern p = Pattern.compile("\\[(.*?)\\]");
Matcher m = p.matcher(line);
while(m.find()) {
    String token = m.group(1);
    String newValue = convert(token);
    line = line.replaceAll(token, newValue);
}