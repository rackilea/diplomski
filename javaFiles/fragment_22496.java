SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
    String sourceDateStr = "20101012";
    try {
        Date sourceDate = sourceFormat.parse(sourceDateStr);

        String targetDateStr = targetFormat.format(sourceDate);

        System.out.println(targetDateStr);
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }