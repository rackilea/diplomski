String time1= "2017-01-31 12:00:00" 
        String time2= "2017-01-31 15:00:00”

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date minDate = format.parse(time1);
        Date maxDate = format.parse(time2);

        for(String row : somearray){
            String rowDateString = row.substring(0,19);
            Date rowDate = format.parse(rowDateString);
            if(rowDate.after(minDate) && rowDate .before(maxDate){
                //get this row because it is between dates
            }
        }