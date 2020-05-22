String Time1 = "10/02/14 09:29:50";
        String Time2 = "11/04/14 09:12:43";

            // date format
            SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");  

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(Time1);
            d2 = format.parse(Time2);
        } catch (ParseException e) {
            e.printStackTrace();
        }    


        long diff = d2.getTime() - d1.getTime();
        long diffSeconds = diff / 1000;         
        long diffMinutes = diff / (60 * 1000);         
        long diffHours = diff / (60 * 60 * 1000);                      
        System.out.println("Time in seconds: " + diffSeconds + " seconds.");         
        System.out.println("Time in minutes: " + diffMinutes + " minutes.");         
        System.out.println("Time in hours: " + diffHours + " hours.");