Pattern p = Pattern.compile("\\d+");
Matcher m = p.matcher(msg.msgContent());
while (m.find()) {
     String number = m.group();
     // add to array
}