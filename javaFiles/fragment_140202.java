int[] hour = new int[2];
    int[] minute = new int[2];

    Calendar rightNow = Calendar.getInstance();

    int tempHour = rightNow.get(Calendar.HOUR_OF_DAY);
    int tempMin  = rightNow.get(Calendar.MINUTE);

    hour[0]   = (int)Math.floor(tempHour/10);
    hour[1]   = tempHour%10;

    minute[0] = (int)Math.floor(tempMin/10);
    minute[1] = tempMin%10;

    System.out.println(hour[0] + "" + hour[1] + ":" + minute[0] + "" + minute[1]);