Calendar    thatDay = null;

ReadPeriodically(Calendar thatDay) {
    this.thatDay = thatDay;
}

@Override
public void run() {

    Calendar today = Calendar.getInstance();

    long diff = (thatDay.getTimeInMillis() - today.getTimeInMillis()) / 1000;
    long days = diff / (60 * 60 * 24);
    long hours = diff / (60 * 60) % 24;
    long mins = diff / 60 % 60;
    long secs = diff % 60;

    System.out.println(days + ":" + hours + ":" + mins + ":" + secs);
}