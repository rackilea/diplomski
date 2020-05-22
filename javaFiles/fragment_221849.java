public Date2(int dd, int mm, int yyyy) {
    this.day = dd;
    this.month = mm;
    this.year = yyyy;

    Calendar calendar = Calendar.getInstance();
    calendar.set(yyyy, mm - 1, dd);
    today = calendar.getTime();

}