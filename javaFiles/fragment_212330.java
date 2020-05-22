private static double getFareRate(String startTime) throws ParseException {

        SimpleDateFormat timeFormatParser = new SimpleDateFormat("HH:mm");
        // 
        Date peakTimeStart = timeFormatParser.parse("16:00");
        Date peakTimeEnd = timeFormatParser.parse("19:00");
        Date nightStart = timeFormatParser.parse("0:00");
        Date nightEnd = timeFormatParser.parse("6:00");
        //
        Date startTimeAsDate = timeFormatParser.parse(startTime);
        if (startTimeAsDate.after(peakTimeStart) && startTimeAsDate.before(peakTimeEnd)) {
            return 2d;
        } else if (startTimeAsDate.after(nightStart) && startTimeAsDate.before(nightEnd)) {
            return 2.4d;
        } else {
            return 1.6d;
        }
    }