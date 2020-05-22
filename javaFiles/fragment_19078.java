do {
        // excluding start date
        if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
        ++workDays;
        }
        startCal.add(Calendar.DAY_OF_MONTH, 1);
    }