DatePickerDialog mDatePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
            year = selectedyear;
            month = selectedmonth;
            day = selectedday;
            String date = "" + day + "-" + (month+1) + "-" + year;
            stardate.setText(date);

SimpleDateFormat simpleDateFormat = 
                new SimpleDateFormat("dd/M/yyyy");

      try {

        Date date1 = simpleDateFormat.parse(""+day+"/"+(month+1)+"/"+year");
        Date date2 = simpleDateFormat.parse("13/10/2013"); //If you want to use the current date, use "new Date()"

    printDifference(date1, date2);

      } catch (ParseException e) {
        e.printStackTrace();
      }

    }
        }
    }, year, month, day);
    mDatePicker.setTitle("Please select date");
    mDatePicker.getDatePicker().

    setMaxDate(System.currentTimeMillis());
    mDatePicker.show();
}
});

//1 minute = 60 seconds
    //1 hour = 60 x 60 = 3600
    //1 day = 3600 x 24 = 86400
    public void printDifference(Date startDate, Date endDate){

        //milliseconds
        long different = endDate.getTime() - startDate.getTime();

        System.out.println("startDate : " + startDate);
        System.out.println("endDate : "+ endDate);
        System.out.println("different : " + different);

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        System.out.printf(
            "%d days, %d hours, %d minutes, %d seconds%n", 
            elapsedDays,
            elapsedHours, elapsedMinutes, elapsedSeconds);

    }