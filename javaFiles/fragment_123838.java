String input =  "AAA10.50.30.20";
Pattern p = p = Pattern.compile("10.([01]?\\d\\d?|2[0-4]\\d|25[0-5]).([01]?\\d\\d?|2[0-4]\\d|25[0-5]).([01]?\\d\\d?|2[0-4]\\d|25[0-5])");
Matcher m = p.matcher(input);
String result = input;
while(m.find()){
    char[] replacement = new char[m.end()-m.start()];
    Arrays.fill(replacement, 'X');
    result = result.substring(0, m.start())
        + new String(replacement)
        + result.substring(m.end());
}
return result;