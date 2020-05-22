Pattern pattern = Pattern.compile("\\bbillId=(\\d+)");
Matcher matcher = pattern.matcher(inputStr);
int billId = 0;

if(matcher.find())
    billId = Integer.parseInt(matcher.group(1));