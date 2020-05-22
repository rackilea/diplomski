SimpleDateFormat parserSDF=new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
        String dateInString = "7-Jun-2013";

        try {

            Date v= formatter.parse(dateInString);


        } catch (ParseException e) {
            e.printStackTrace();
        }