public void helper(List<String> result, int[] time, int num, int start, int hour, int minute){
    if (start == time.length && num > 0)
        return;

    if (num == 0){
        if (hour <= 12 && minute <= 59){
            String x = "" + hour + ":";
            if (minute < 10){x = x + "0";}
            x = x + minute;
            result.add(x);
        }
    } else {
        helper(result, time, num, start + 1, hour, minute);
        int h, m;
        if (start >= 4){h = hour; m = minute + time[start];} else {h = hour + time[start]; m = minute;}
        helper(result, time, num - 1, start + 1, h, m);
    }
}