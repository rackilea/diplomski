String stringReceivedInSms="<+923451234567>: Hi here is the text.";

Pattern pattern = Pattern.compile("<\\+?([0-9]+)>: (.*)");
Matcher matcher = pattern.matcher(stringReceivedInSms);
if(matcher.matches()) {
    String phoneNumber = matcher.group(1);
    String messageText = matcher.group(2);
}