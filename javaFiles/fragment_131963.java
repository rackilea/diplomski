String date = "2018-01-09T11:11:02.0+03:00";
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        SimpleDateFormat output = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        Date d = null;
        try {
            d = dateformat.parse(date /*your date as String*/);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedDate = output.format(d);

        Log.d("Date format", "output date :" + formattedDate);