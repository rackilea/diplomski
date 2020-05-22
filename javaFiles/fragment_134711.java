public static String calculateReportingPeriod(String year, String month,
            String dateFormat) {
        String reportingPeriod = new String();
        Calendar calendar = Calendar.getInstance();
        if (year == null || year.isEmpty()) {
            Integer lyear = Calendar.getInstance().get(Calendar.YEAR);
            year = lyear.toString();
        }
        if (month == null || month.isEmpty()) {
            Integer lmonth = Calendar.getInstance().get(Calendar.MONTH);
            /**
             * -1 because report in generate for previous month
             */
            lmonth = lmonth - 1;
            month = lmonth.toString();
        } else {
            Integer lmonth = Integer.parseInt(month);
            lmonth = lmonth - 1;
            month = lmonth.toString();
        }
        if (dateFormat == null || dateFormat.isEmpty()) {
            dateFormat = DATE_FORMAT;
        }
        /**
         * calculating max days in the given month and given year
         */
        calendar.set(Calendar.YEAR, Integer.parseInt(year));
        calendar.set(Calendar.MONTH, Integer.parseInt(month));
        Integer maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar.set(Integer.parseInt(year), Integer.parseInt(month),
                START_DATE);
        Date reportingStartDt = calendar.getTime();
        reportingPeriod = new SimpleDateFormat(dateFormat)
                .format(reportingStartDt);
        reportingPeriod = reportingPeriod.concat(EMPTY_STRING);
        reportingPeriod = reportingPeriod.concat(DASH_SEPERATOR);
        reportingPeriod = reportingPeriod.concat(EMPTY_STRING);
        calendar.set(Calendar.DATE, maxDays);
        Date reportingEndDt = calendar.getTime();
        reportingPeriod = reportingPeriod.concat(new SimpleDateFormat(
                dateFormat).format(reportingEndDt));
        return reportingPeriod;
    }