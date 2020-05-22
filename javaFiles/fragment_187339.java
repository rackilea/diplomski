public static void main(String[] args) {


    Time time = new Time(00,00,00);
    Time time2 = new Time(02,00,00);

    long longTime = (time2.getTime() - time.getTime());

    Time finalTime = new Time(longTime);

    int timeOffset = time.getTimezoneOffset();
    finalTime.setMinutes(finalTime.getMinutes()+timeOffset);

    System.out.println(finalTime.toString());   

    }