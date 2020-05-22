public static void main(String[] args) throws ParseException {
        String dateStr = "1999-12-30 12:34:45";
        String formatStr = "yyyy-MM-dd HH:mm:ss";
        String formatStrOther = "yyyyMMdd";
        Date testDate = null;
        SimpleDateFormat sdf= new SimpleDateFormat(formatStr);
        SimpleDateFormat sdfOther= new SimpleDateFormat(formatStrOther);
        sdf.setLenient(false);
        testDate = sdf.parse(dateStr);
        Integer otherDate = Integer.valueOf(sdfOther.format(testDate));
        System.out.println("Newly formatted date in int is: " + otherDate); //prints Newly formatted date in int is: 19991230

    }