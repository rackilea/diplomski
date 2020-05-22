Date[] dates = new Date[2];
        dates[1] = new Date(System.currentTimeMillis()-12*1000*60*60);
        dates[0] = new Date(System.currentTimeMillis());
        Date mostRecentDate = dates[0];
        Date previousDate = dates[1];

        double mostRecentTime = mostRecentDate.getTime();
        double previousTime = previousDate.getTime(); 

        double diffInDays = (mostRecentTime - previousTime ) / (1000 * 60 * 60 * 24);