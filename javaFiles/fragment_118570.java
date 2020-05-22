String format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

Date testStart = format.parse("05/05/2014 12:02:59");
Date testEnd = format.parse("15/05/2014 09:44:20");

for(int i=0; i<testOutput.getResultBody().getPaymentResult().size(); i++) {
    String dateStr = paymentOutput.getResultBody().getPaymentResult().get(i).getMyDate();
    Date date = format.parse(dateStr);
    if (date.compareTo(testStart) >= 0 && date.compareTo(testEnd) < 0) {
        System.out.println(dateStr);
    }
}