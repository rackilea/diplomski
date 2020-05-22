public static int diff(int hour1, int hour2) {
    if(hour2 < hour1) {
        hour2 += 24;
    }
    return hour2 - hour1;
}