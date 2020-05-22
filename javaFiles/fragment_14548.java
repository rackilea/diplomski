to.set(Calendar.YEAR, year);
            to.set(Calendar.MONTH, monthOfYear);
            to.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            from = Calendar.getInstance();
            from.set(Calendar.YEAR, yearEnd);
            from.set(Calendar.MONTH, monthOfYearEnd);
            from.set(Calendar.DAY_OF_MONTH, dayOfMonthEnd);

            Date toTime = to.getTime();
            Date fromTime = from.getTime();

            int days2 = Days.daysBetween(new DateTime(toTime), new DateTime(fromTime)).getDays();
            days2++;