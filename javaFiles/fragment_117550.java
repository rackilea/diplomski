boolean work = true;
        int day = 0; // 0 = today, 1 = yesterday etc...
        int subDay = 0; // subtract day 


        while (work){   
        Calendar cal = Calendar.getInstance(); // get current time
        cal.add(Calendar.DAY_OF_WEEK, subDay); // subtract day

        // working days are Mon, Tue, Wed, Thu, Fri. If we get saturdays or sundays, we want to skip that days,
        // so we use if declaration


        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            subDay--;
            continue;
        }



           Date tday=cal.getTime(); 
           SimpleDateFormat dy = new SimpleDateFormat("EEE");
           String d9 = dy.format(tday);
           System.out.println("Day: " + day + " - " + d9);  

           day ++; 
           subDay--;

           if (day >= 10){work=false;} // here we declara how much day we want to go back, and we break loop.

        }