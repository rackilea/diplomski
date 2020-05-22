Calendar currTime = Calendar.getInstance();
         int hour = currTime.get(Calendar.HOUR_OF_DAY);
                int min = currTime.get(Calendar.MINUTE);

        try {
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
        Date lunchStart  = parser.parse("11:29");
        Date lunchStop   = parser.parse("13:31");
        Date dinnerStart = parser.parse("17:29");
        Date dinnerStop  = parser.parse("23:31");


            Date userDate = parser.parse(hour+":"+min);
            //for lunch
            if (userDate.after(lunchStart) && userDate.before(lunchStop)) {
                System.out.println("lunch");
            }
            else if (userDate.after(dinnerStart) && userDate.before(dinnerStop))
            {
                   System.out.println("dinner");
            }
            else{

                System.out.println("We are Closed!!");
            } 
        } catch (ParseException e) {
            // Invalid date was entered
        }