String inputString = "I walked played with bobby robby my dog";
Pattern p = Pattern.compile("([a-z]{2})\\s([a-z]{0,})\\1");
Matcher m = p.matcher(inputString);
while (m.find()) {
    inputString = inputString.substring(0, m.start(2) - 1) + ", " + inputString.substring(m.start(2));
    m = p.matcher(inputString);
}