public void advance(int advance) {
    int whichAmPm = 0;
    minute += advance;
    while (minute > 59) {
        hour++;
        minute -= 60;
        if (hour > 12) { // <-- this is safe because the above increments hour once
            hour -= 12;
            whichAmPm++;
        }
    }
    if (whichAmPm % 2 != 0) {
        amPm = amPm.equals("AM") ? "PM" : "AM";
    }
}