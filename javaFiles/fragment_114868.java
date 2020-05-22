int time1 = (hours1 * 60 + min1) * 60 + sec1;
int time2 = (hours2 * 60 + min2) * 60 + sec2;
int total = time1 + time2;
short hour = total / 3600;
short minute = total / 60 % 60;
short second = total %60;