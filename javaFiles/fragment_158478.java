String testDate = "20140812163222";
    SimpleDateFormat inDateFormet = new SimpleDateFormat("yyyyMMddHHmmss");
    SimpleDateFormat setDateFormet = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    ....
    Date parseDate = inDateFormet.parse(testDate);
    String resultdate = setDateFormet.format(parseDate);