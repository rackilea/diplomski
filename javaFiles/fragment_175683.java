public static long convertdatetotimestamp(String datestring, String newdateformat, String olddateformat){
        DateFormat originalFormat = new SimpleDateFormat(olddateformat,Locale.ENGLISH);
        DateFormat targetFormat = new
                SimpleDateFormat(newdateformat,Locale.ENGLISH);
        Date date = null;
        try {
            date = originalFormat.parse(datestring.replaceAll("\\.", ""));
            String formattedDate = targetFormat.format(date);
            Date parsedDate = targetFormat.parse(formattedDate);
            long nowMilliseconds = parsedDate.getTime();

            return nowMilliseconds;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }

    }