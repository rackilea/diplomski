private static int getMonth(String date) throws ParseException{  
            Date d = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
            int month = cal.get(Calendar.MONTH);
            return month + 1;
    }