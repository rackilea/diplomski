int n = // day of year 
for (int i = 1; i < daysInMonth.length; i++) {
    if(n <= daysInMonth[i])
         break;// n is the day of month i
    else n -= daysInMonth[i];
}