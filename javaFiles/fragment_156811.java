long i = 0;
    java.util.Date date = new java.util.Date(i);


    for (i = 1000; i < 100000000000L; i *= 10) {
        date.setTime(i);

        System.out.println("Time elapsed: " + i + " milliseconds");
        System.out.println("Date and time: " + date.toString());
    }


    }