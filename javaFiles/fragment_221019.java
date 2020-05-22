private boolean matchDate(Calendar createdDate, DateDomain dateRange) {

        Calendar fromDateCal = Calendar.getInstance();
        fromDateCal.setTime(dateRange.getDateFromD());

        Calendar toDateCal = Calendar.getInstance();
        toDateCal.setTime(dateRange.getDateToD());

        return createdDate.after(fromDateCal) && createdDate.before(toDateCal);

    }