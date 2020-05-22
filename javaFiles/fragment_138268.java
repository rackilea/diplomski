Calendar macEpoch = Calendar.getInstance();
    macEpoch.setTimeInMillis(0);
    macEpoch.set(1904,0, 1, 0, 0, 0);

    //On a mac
    Calendar macTimeForToday = Calendar.getInstance();

    System.out.println("ms since mac epoch: " + macTimeForToday.getTimeInMillis());
    System.out.println("ms since epoch: " + (macTimeForToday.getTimeInMillis() + macEpoch.getTimeInMillis()));