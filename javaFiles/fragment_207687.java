public Date getDateInUtc() {
        String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        Date dateToReturn = null;

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        String utcTime = sdf.format(new Date());

        try {
            dateToReturn = dateFormat.parse(utcTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateToReturn;
    }