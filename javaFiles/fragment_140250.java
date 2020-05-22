private static final Pattern QR_PATTERN = Pattern.compile("^blocka#(\\d+)#(\\d+)$");
public void Store_QR(String qr){
    Matcher matcher = QR_PATTERN.matcher(qr);
    if(matcher.matches()) {
        int number1 = Integer.valueOf(matcher.group(1));
        int number2 = Integer.valueOf(matcher.group(2));
       CurrentLocation = qr;
    }
    else // Break the operation
 }